/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.util.ArrayList;

/**
 *
 * @author dani
 */
public class InheritanceExample {
    public static void main(String[] args) {
        ArrayList<A> as = new ArrayList<A>();
        
        as.add(new A1());
        as.add(new A2());
        
        for (A a : as) {
            // This doesn't work    
            //a.triliri(); 
            a.tocoto(); // This does
            
        }
    }
}

abstract class A {
    public void tocoto(){}
}

class A1 extends A {
    public void triliri(){}

}

class A2 extends A {}