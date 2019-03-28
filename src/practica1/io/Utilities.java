/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import practica1.mice.Colony;
import practica1.mice.Gender;
import practica1.mice.Mouse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 *
 * @author dani
 */
public class Utilities {

    public static Colony openPopulationFile(String fileName) throws IOException {
        FileReader fileReader = null;
        BufferedReader reader = null;
        Colony colony = null;
        
        while (reader == null) {
            try {
                fileReader = new FileReader(fileName); // Set true for append mode
                reader = new BufferedReader(fileReader);
            } catch (FileNotFoundException ex) {
                System.out.println("The file " + fileName + " doesn't seem to exist. Please choose another one");
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                try {
                    fileName = console.readLine();
                } catch (IOException e) {
                    ex.printStackTrace();
                }
            }
        }

        String code = reader.readLine().split(": ", 2)[1];
        String caretaker = reader.readLine().split(": ", 2)[1];
        int daysInHouse = Integer.parseInt(reader.readLine().split(": ", 2)[1]);

        colony = new Colony(code, caretaker, daysInHouse);
        
        String line = null;
        while ((line = reader.readLine()) != null){
            colony.add(mouseFromLine(line));
        
        }
        
        return colony;                
    }

    public static Colony createPopulationFile(String fileName) {
        File file = new File(fileName);
        Colony colony = null;
        Boolean done = false;

        while (!done) {
            try {
                colony = takeColonyFromInput();
                file.createNewFile();
                done = true;
            } catch (IOException ex) {
                System.out.println("There was a problem, please try again");
                ex.printStackTrace();
            }
        }

        save(colony, fileName);

        return colony;
    }

    public static Colony takeColonyFromInput() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the new colony's code");
        String colonyCode = console.readLine();
        System.out.println("Please input the new colony's caretaker");
        String caretaker = console.readLine();
        System.out.println("Please input the new colony's days to remain in house");
        int daysInHouse = Integer.parseInt(console.readLine());

        return new Colony(colonyCode, caretaker, daysInHouse);
    }

    public static Mouse takeMouseFromInput(String message) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(message);
        System.out.println("Please input the new mouse's reference");
        String reference = console.readLine();
        System.out.println("Please input the new mouse's birth date");
        LocalDate birthDate = LocalDate.parse(console.readLine(), formatter);

        System.out.println("Please input the new mouse's gender: Male or female?");
        Gender gender = Gender.MALE;
        if (console.readLine().toLowerCase().contains("f")) {
            gender = Gender.FEMALE;
        }

        System.out.println("Please input the new mouse's X chromosome: is it mutated?");

        Boolean chrom1 = Boolean.parseBoolean(console.readLine());

        if (gender == Gender.FEMALE) {
            System.out.println("Please input the new mouse's second X chromosome: is it mutated?");
        } else {
            System.out.println("Please input the new mouse's Y chromosome X: is it mutated?");
        }
        Boolean chrom2 = Boolean.parseBoolean(console.readLine());

        System.out.println("Please input the new mouse's weight in grams:");
        int weight = Integer.parseInt(console.readLine());
        System.out.println("Please input the new mouse's temperature in degrees C:");
        Float temperature = Float.parseFloat(console.readLine());
        System.out.println("Please input any comments about the new mouse that you may have:");
        String comments = console.readLine();

        return new Mouse(reference, birthDate, gender, weight, temperature, chrom1, chrom2, comments);
    }

    public static String getString(String message) {
        String result = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (result == null) {
            try {
                System.out.println(message);
                result = reader.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void save(Colony colony, String fileName) {
        FileWriter fileWriter = null;
        while (fileWriter == null) {
            try {
                fileWriter = new FileWriter(fileName);

            } catch (IOException ex) {
                System.out.println("There as a problem opening file " + fileName);
                ex.printStackTrace();
            }
        }

        PrintWriter writer = new PrintWriter(fileWriter);
        writer.println("Colony code: " + colony.getCode());
        writer.println("Colony caretaker: " + colony.getCaretaker());
        writer.println("Colony days in house: " + colony.getDaysInHouse());

        try {
            writer.close();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (colony.getMice() != null) {
            for (Mouse mouse : colony.getMice()) {
                save(mouse, fileName);
            }
        }
    }

    public static void save(Mouse mouse, String fileName) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true); // Set true for append mode
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(mouse.toLine());

        } catch (IOException ex) {
            System.out.println("There was a problem opening file " + fileName);
            ex.printStackTrace();
        } finally {
            printWriter.close();
            try {
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println("There was a problem closing file " + fileName);
                ex.printStackTrace();
            }
        }

    }
    
    public static Mouse mouseFromLine(String line) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String[] fields = line.split("\\|");
        System.out.println(Arrays.toString(fields));
        String reference = fields[0];
        LocalDate birthDate = LocalDate.parse(fields[1], formatter);
        Gender gender = Gender.MALE;
        if (fields[2].toLowerCase().contains("f")) {
        gender = Gender.FEMALE;
        }
        Boolean chrom1 = Boolean.parseBoolean(fields[3]);
        Boolean chrom2 = Boolean.parseBoolean(fields[4]);
        int weight = Integer.parseInt(fields[5]);
        float temperature = Float.parseFloat(fields[6]);
        
        
        return new Mouse(reference, birthDate, gender, weight, temperature, chrom1, chrom2, fields[7]);
    }

}
