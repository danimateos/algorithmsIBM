/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 * Crea una clase fecha que almacene el día, el mes y el año de una fecha.
 * Proporciona funciones miembro para acceder a estos atributos (getDia(),
 * getMes() y getAño() y para modificarlos (getDia(int dia), getMes(int mes) y
 * getAño(int año)). Sobreescribe su método toString(). Crea la fecha
 * 20/10/2018. Muéstrala por pantalla. Después cambia el año 2019. Muéstrala por
 * pantalla.
 *
 * @author dani
 */
public class Exercise02 {

    public static void main(String[] args) {
        Date firstDate = new Date(2018, 10, 20);
        System.out.println(firstDate);
        firstDate.setYear(2019);
        System.out.println(firstDate);
    }

}

