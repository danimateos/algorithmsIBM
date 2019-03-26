/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author dani
 */
public class ThisExample {

    public static void main(String[] args) {
        Car micochetoguapo = new Car("Honda", "Civic", 2017);
        Car estatartana = new Car("Ford", "Fiesta", 1982);
    }
}

class Car {

    String make, model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

}

