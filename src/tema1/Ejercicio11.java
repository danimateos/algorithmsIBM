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
public class Ejercicio11 {

    public static void main(String[] args) {
        float[][] matrix1 = new float[0][0], matrix2 = new float[0][0], result = new float[0][0];
        int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
        String input;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Please input: i1");
            input = console.readLine();
            i1 = Integer.parseInt(input);
            System.out.println("Please input: j1");
            input = console.readLine();
            j1 = Integer.parseInt(input);
            System.out.println("Please input: i2");
            input = console.readLine();
            i2 = Integer.parseInt(input);
            System.out.println("Please input: j2");
            input = console.readLine();
            j2 = Integer.parseInt(input);

            matrix1 = new float[i1][j1];
            matrix2 = new float[i2][j2];

            for (int i = 0; i < i1; i++) {
                for (int j = 0; j < j1; j++) {
                    System.out.println("Please input: matrix 1, element [" + i + "][" + j + "]");
                    input = console.readLine();
                    matrix1[i][j] = Float.parseFloat(input);
                }
            }

            for (int i = 0; i < i2; i++) {
                for (int j = 0; j < j2; j++) {
                    System.out.println("Please input: matrix 2, element [" + i + "][" + j + "]");
                    input = console.readLine();
                    matrix2[i][j] = Float.parseFloat(input);
                }
            }

        } catch (IOException ex) {
            System.out.println("Error defining matrices");
        }

        result = new float[i1][j2];

        for (int i = 0; i < i1; i++) {
            for (int j = 0; j < j2; j++) {
                System.out.println("Calculating element [" + i + "][" + j + "]");
                result[i][j] = 0.0F;

                for (int k = 0; k < j1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        for (float[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        
    }
}
