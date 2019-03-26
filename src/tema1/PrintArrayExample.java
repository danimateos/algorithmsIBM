/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.util.Arrays;

/**
 *
 * @author dani
 */
public class PrintArrayExample {
    public static void main(String[] args) {
        char[] charArray = {'a', 'e', 'i', 'o', 'u'};
        int[] intArray = {1,2,3,4,5};
        
        System.out.println(charArray);
        System.out.println(intArray);
        
        for (int i : intArray) {
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println(Arrays.toString(intArray));
    }
}
