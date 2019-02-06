/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 * Escribir un programa que defina variables que representen el número de días
 * de un año, el número de horas que tiene un día, el número de minutos que
 * tiene una hora y el número de segundos que tiene un minuto. Emplear las 
 * variables que ocupen el mínimo espacio de memoria posible. A continuación,
 * calcular el número de segundos que tiene un año y almacenar el valor del 
 * cálculo en otra variable.
 * 
 * @author dani
 */
public class Exercise01 {

    public static void main(String[] args) {
        short daysInYear = 365;
        byte hoursInDay = 24, minutesInHour = 60, secondsInMinute = 60;
        int secondsInYear = daysInYear * hoursInDay * minutesInHour * secondsInMinute;

        System.out.println("Seconds in a year: " + secondsInYear);
    }
}
