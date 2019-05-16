/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dani
 */
public class CollectionsExample {

    public static void example1(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            a.add(i);
        }

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                b.add(i);
            }
        }

        System.out.println(a);
        System.out.println(b);
        b.removeAll(a);
        System.out.println(b);
    }

    public static void example2(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            a.add(i);
        }

        Iterator<Integer> it = a.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
        
        for (int element : a) {
            System.out.println(element);
        }
    }
}
