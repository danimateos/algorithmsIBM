/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dani
 */
public class ForEachExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();

        System.out.println("---------\nStandard for:");
       
        list.add("lunes");
        list.add("martes");
        list.add("miercoles");
        list.add("jueves");
        list.add("viernes");
        list.add("sabado");
        list.add("domingo");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Hoy es " + list.get(i));
        }
        
        System.out.println("---------\nFor-each:");
        
        for (String day : list) {
            System.out.println("Hoy es " + day);
        }
        
    }
}
