/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 * Escribir un programa que muestre por consola los mayores números enteros
 * que se pueden representar mediante un char, short e int.
 * 
 * @author dani
 */
public class Exercise02 {

    public static void main(String[] args) {
        char maxChar = 0xFFFF;
        short maxShort = 0x7FFF;
        int maxInt = 0x7FFFFFFF;

        System.out.println("minChar " + (char) (maxChar + 1));
        System.out.println("minShort " + (short) (maxShort + 1));
        System.out.println("minInt " + (maxInt + 1));
    }
}
