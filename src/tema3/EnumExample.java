/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dani
 */
public class EnumExample {

    public static void main(String[] args) {
        try {
            Person.Sexo sexo;
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String input = console.readLine();
            if (input.toLowerCase().contains("f")) {
                sexo = Person.Sexo.MUJER;
            } else {
                sexo = Person.Sexo.HOMBRE;
            }
            Person myaunt = new Person(sexo);
            System.out.println(Person.Sexo.MUJER);
        } catch (IOException ex) {
        }
    }
}

class Person {

    enum Sexo {
        MUJER, HOMBRE
    };
    Sexo sexo;

    Person(Sexo sexo) {
        this.sexo = sexo;

    }
}
