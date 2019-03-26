/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author dani
 */
public class Exercise01 {

    public static void main(String[] args) {
        String line = "";
        BufferedReader console = null;
        PrintWriter writer = null;

        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            writer = new PrintWriter(new File("out.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        
        
        while (!line.equals("x")) {
            try {
                System.out.println("Please enter a line")        ;
                line = console.readLine();
                writer.println(line);
            } catch (IOException e) {
                System.out.println("Error:");
                e.printStackTrace();

            }
        }
        
        writer.close();

    }
}
