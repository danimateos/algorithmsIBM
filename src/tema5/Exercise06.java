/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;

/**
 *
 * @author dani
 */
public class Exercise06 {

    public static int valueOf(String hex) {

        String digits = "0123456789ABCDEF";

        if (hex.length() == 1) {
            return digits.indexOf(hex);
        } else {
            // Reduce the string from right to left
            int lastDigit = digits.indexOf(hex.substring(hex.length() - 1));
            return  lastDigit + 16 * valueOf(hex.substring(0, hex.length() - 1));
        }

    }

    public static void main(String[] args) {
        System.out.println(valueOf("1FF"));
    }

}
