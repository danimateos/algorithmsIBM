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
 *
 * @author dani
 */
public class ResizeArrayExample {

    public static void main(String[] args) {
        int[] array = new int[0], arraycopy = new int[0];
        int pos = 0, input;

        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                if (array.length <= pos) {
                    arraycopy = new int[pos + 1];
                    for (int i = 0; i < array.length; i++) {
                        arraycopy[i] = array[i];
                    }
                }
                System.out.println("Please enter an int");
                String string = console.readLine();
                input = Integer.parseInt(string);
                if (input <= 0) {
                    break;
                }
                arraycopy[pos] = input;
                array = arraycopy.clone();
                pos++;

            }
        } catch (IOException ex) {
            System.out.println("Something happened");
        }
        System.out.println(Arrays.toString(array));
    }
}
