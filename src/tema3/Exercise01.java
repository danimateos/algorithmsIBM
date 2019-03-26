/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 * Escribe un programa que cree una clase para representar un objeto punto en
 * tres dimensiones. Proporcionar un constructor que inicialice los valores del
 * punto al origen de coordenadas y otro que permita especificar las coordenadas
 * del punto. Sobrescribe su método toString() para que muestre información
 * sobre los puntos. Usa la clase en un programa donde crees objetos que
 * representen los puntos (12, 13, 18) y (8, 14, 0) y los muestres por consola.
 *
 * @author dani
 */
public class Exercise01 {

    public static void main(String[] args) {
        Point pointA = new Point();
        Point pointB = new Point(12, 13, 18);
        Point pointC = new Point(8, 14, 0);

        System.out.println(pointA);
        System.out.println(pointB);
        System.out.println(pointC);
    }

}

class Point {

    protected int x, y, z;

    public Point() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Point(int _x, int _y, int _z) {
        x = _x;
        y = _y;
        z = _z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
