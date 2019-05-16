/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dani
 */
public class AnonymousComparatorExample {

    public static void main(String[] args) {
        List<Wrapper> list = new ArrayList();

        list.add(new Wrapper("holi", 1));
        list.add(new Wrapper("adiosi", 100));
        list.add(new Wrapper("tocoto", 50));

        Collections.sort(list, new Comparator<Wrapper>() {

            public int compare(Wrapper one, Wrapper other) {
                if (one.integer < other.integer) {
                    return -1;
                } else if (one.integer > other.integer) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("Sorted by integer");
        System.out.println(list);

        Collections.sort(list, new Comparator<Wrapper>() {

            public int compare(Wrapper one, Wrapper other) {
                return one.string.compareTo(other.string);
            }
        });

        System.out.println("Sorted by string");
        System.out.println(list);
    }
}

class Wrapper {

    protected String string;
    protected int integer;

    public Wrapper(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }
    
    public String toString(){
        return "(" + string + ", " + integer + ")";
    }

}
