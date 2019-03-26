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
import practica1.mice.Mouse;

/**
 *
 * @author dani
 */
public class Utilities {

    public static Colony openPopulationFile(String fileName) {
        FileReader fileReader = null;
        while (fileReader == null) {
            try {
                fileReader = new FileReader(fileName); // Set true for append mode
            } catch (FileNotFoundException ex) {
                System.out.println("The file " + fileName + " doesn't seem to exist. Please choose another one");
            }
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Colony createPopulationFile(String fileName) {
        File file = new File(fileName);
        Boolean done = false;
        while (!done) {
            try {
                done = file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Colony colony = takeColonyFromInput();
        save(colony, fileName);

        return colony;
    }

    public static Colony takeColonyFromInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Mouse takeMouseFromInput(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        for (Mouse mouse : colony.getMice()) {
            save(mouse, fileName);
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

}
