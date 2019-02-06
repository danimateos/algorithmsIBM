/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.util.Arrays;
import java.util.Random;

/**
 * Escribir un programa que rellene una matriz cuadrada (las dimensiones de la
 * matriz serán un parámetro que se pida al usuario) con números aleatorios de
 * tal modo que la matriz sea simétrica. Imprimir la matriz por pantalla.
 *
 * @author dani
 */
public class Exercise10 {

    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                int content = random.nextInt() % 100;
                matrix[i][j] = content;
                matrix[j][i] = content;
            }
        }

        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
    }

}
