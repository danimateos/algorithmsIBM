/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio voluntario: escribir un programa que genere una cadena de ADN
 * aleatoria con un tamaño de 10,000,000 de pares de bases. A continuación el
 * usuario introducirá una tripleta de pares de bases (por ejemplo CGC) y el
 * programa deberá indicar cuántas veces sucede esa tripleta en la cadena.
 *
 * @author dani
 */
public class Exercise15 {

    public static void main(String[] args) {
        String triplet = "GCG";
        int strandLength = 100000000;
        char[] strand = new char[strandLength];
        char[] alphabet = {'A', 'G', 'C', 'T'};
        Random random = new Random();
        int count = 0;

        System.out.println("Starting generation of DNA strand");
        System.out.println(LocalDateTime.now().toString());
        for (int i = 0; i < strandLength; i++) {
            int choice = Math.abs(random.nextInt()) % 4;
            strand[i] = alphabet[choice];
        }

        System.out.println("Generation of DNA strand done");
        System.out.println(LocalDateTime.now().toString());

        for (int i = 0; i < strand.length - 2; i++) {
            if (i % 10000000 == 0) {
                System.out.println(LocalDateTime.now().toString() + " position  " + i);
            }
            if (triplet.equals(new String(Arrays.copyOfRange(strand, i, i + 3)))) {
                count++;
            }
        }

        System.out.println(new String(strand).substring(0, 50) + "(...)\ncontains " + count + " instances of " + triplet);
    }
}
