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
public class StackExample {
    public static void main(String[] args) {
        List<String> pila = new LinkedList();
        
        pila.add("Uno");
        pila.add("Dos");
        pila.add("Tres");
        
        
        String lifo = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        System.out.println(lifo);
        
    }
    
}
