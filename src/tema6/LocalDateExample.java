/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6;

import java.time.LocalDate;

/**
 *
 * @author dani
 */
public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.parse("1984-05-23");
        System.out.println(birthday);
        System.out.println(birthday.getDayOfMonth());
        System.out.println(birthday.getDayOfWeek());
        
    }
}
