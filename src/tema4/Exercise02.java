/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author dani
 */
public class Exercise02 {

    public static void main(String[] args) {
        PrintWriter writer = null;
        FileReader reader = null;
        BufferedReader bReader = null;

        String fileName = "out.txt";
        int option = -1;

        try {
            writer = new PrintWriter(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        Menu menu = new Menu();

        do {
            try {
                option = menu.getOption();
                if (option == 1) {
                    writeToFile(writer);
                } else if (option == 2) {
                    readWholeFile(fileName);
                }
            } catch (IOException e) {
                System.out.println("Error");
                System.out.println(e);
                e.printStackTrace();
            }

        } while (option != 3);

    }

    private static void writeToFile(PrintWriter writer) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (true) {
            System.out.println("Please enter a line");
            line = console.readLine();
            if (line.equals("x")) {
                break;
            } else {
                writer.println(line);
            }
        }
        writer.close();
    }

    private static void readWholeFile(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;

        do {
            line = reader.readLine();
            if (line != null) {
                System.out.println(line);
            }
        } while (line != null);

    }
}

class Menu {

    BufferedReader console;

    public Menu() {
        this.console = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getOption() {
        String line = "";
        System.out.println("Choose an option:");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.println("3. Exit");
        try {
            line = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(line);

    }

}
