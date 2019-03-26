/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dani
 */
public class Exercise06 {

    public static void main(String[] args) {

        String fileName = "out.txt";
        int option = -1;

        Menu06 menu = new Menu06();

        do {
            try {
                option = menu.getOption();
                if (option == 1) {
                    Contact contact = getContactInfo();
                    writeToFile(contact, fileName);
                } else if (option == 2) {
                    readFromFile(fileName);
                }
            } catch (IOException e) {
                System.out.println("Error: could not read or write");
                System.out.println(e);
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Error: please input number");
                System.out.println(e);
                e.printStackTrace();
            
            }

        } while (option != 3);

    }

    static void writeToFile(Contact contact, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true); // Set true for append mode
        PrintWriter writer = new PrintWriter(fileWriter);
        writer.println(contact.toString());
        writer.close();
    }

    static void readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static Contact getContactInfo() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please input name");
        String name = console.readLine();
        System.out.println("Please input email");
        String email = console.readLine();
        System.out.println("Please input phone number");
        int phoneNumber = Integer.parseInt(console.readLine());

        return new Contact(name, email, phoneNumber);
    }

}

class Menu06 {

    BufferedReader console;

    public Menu06() {
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

class Contact {

    String name, email;
    int phoneNumber;

    public Contact(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static Contact fromString(String stringifiedContact) {
        String[] fields = stringifiedContact.split("|");

        String name = fields[0];
        String email = fields[1];
        int phoneNumber = Integer.parseInt(fields[2]);

        return new Contact(name, email, phoneNumber);
    }

    @Override
    public String toString() {
        return name + "|" + email + "|" + phoneNumber;
    }

}
