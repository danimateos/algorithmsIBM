/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Escribe un programa que calcule el mínimo y el máximo de una lista de
 * números enteros positivos introducidos por el usuario. La lista finalizará
 * cuando se introduzca un número negativo.
 * 
 * @author dani
 */
public class Exercise04 {

    public static void main(String[] args) {
        int min = 0x7FFFFFFF;
        int max = min + 1;

        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Please input a number");
                String line1 = consola.readLine();
                int input = Integer.parseInt(line1);

                if (input < 0) {
                    break;
                }
                if (input < min) {
                    min = input;
                }
                if (input > max) {
                    max = input;
                }
            }

        } catch (IOException ex) {
            System.out.println("Error");
        }
        System.out.println("Min: " + min + "\nMax: " + max);
    }
}
