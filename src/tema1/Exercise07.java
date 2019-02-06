/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Escribe un programa que lea un número entero de teclado y lo descomponga en
 * factores primos; por ejemplo 40 = 2 * 2 * 2 * 5.
 *
 * @author dani
 */
public class Exercise07 {

    /**
     *
     * TODO: Dynamically resize array
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] primeFactors = new int[10];
        int found = 0;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        try {
            System.out.println("Please introduce a number to factor");
            input = console.readLine();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }

        int i = Integer.parseInt(input);

        while (i > 1) {
            for (int candidate = 2; candidate <= i; candidate++) {
                System.out.println("i: " + i + "; candidate: " + candidate);

                if (i % candidate == 0) {

                    i /= candidate;

                    primeFactors[found] = candidate;
                    found++;
                    break;
                }

            }

        }

        System.out.println(input + ": " + Arrays.toString(primeFactors));

    }
}
