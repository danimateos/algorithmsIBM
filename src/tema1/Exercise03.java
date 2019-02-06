/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 * Calcular la suma de todos los múltiplos de 5 comprendidos entre 1 y 100.
 * Calcular además cuantos hay y visualizar cada uno de ellos.
 * 
 * @author dani
 */
public class Exercise03 {

    public static void main(String[] args) {
        int sum = 0, count = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0) {
                System.out.println(i);
                sum += i;
                count += 1;
            }
        }

        System.out.println(sum);
        System.out.println(count);
    }
}
