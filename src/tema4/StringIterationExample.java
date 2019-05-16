/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author dani
 */
public class StringIterationExample {

    public static void main(String[] args) {
        
        
        String test = "esto es una prueba";

        
        for (char c : test.toCharArray()) {
            if (c == ' ') {
                System.out.println("Es un espacio!");
            }

        }
    }
}
