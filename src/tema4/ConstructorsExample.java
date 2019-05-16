/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dani
 */
public class ConstructorsExample {

    // Esto esta feisimo
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        MyClass instance = new MyClass();
        try {
            int attribute = Integer.parseInt(console.readLine());
            instance.setAttribute1(attribute);
            String otherAttribute = console.readLine();
            instance.setAttribute2(otherAttribute);
        } catch (IOException ex) {
            System.out.println("The instance now has nonsensical attributes");
            ex.printStackTrace();
        }
    }

    public static void bien(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        MyClass instance = null;
        try {
            int attribute = Integer.parseInt(console.readLine());
            String otherAttribute = console.readLine();
            instance = new MyClass(attribute, otherAttribute);
        } catch (IOException ex) {
            System.out.println("The instance now doesn't exist; it's null");
            ex.printStackTrace();

        }

    }
}

class MyClass {

    int attribute1;
    String attribute2;

    public MyClass() {
        this.attribute1 = 0;
        this.attribute2 = null;
    }

    public MyClass(int attribute1, String attribute2) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
    }

    public int getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(int attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

}
