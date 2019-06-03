/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenFinal2019;

import java.util.Arrays;

/**
 *
 * @author dani
 */
public class Ordenacion {

    public static void main(String[] args) {

        String[] strings = {"x", "a", "b", "h", "c", "i", "b"};
        System.out.println("--------------\nMétodo de la burbuja:\n ");
        burbuja(strings.clone());
        System.out.println("\n--------------\nMétodo de la inserción: \n");
        insercion(strings.clone());
        System.out.println("\n--------------\nMétodo de la selección: \n");
        seleccion(strings.clone());

    }

    private static void burbuja(String[] datos) {
        String auxiliar;
        for (int pasada = 0; pasada < datos.length; pasada++) {
            System.out.println("Pasada " + pasada);
            System.out.println(Arrays.toString(datos));
            for (int i = 0; i < datos.length - 1 - pasada; i++) {
                if (datos[i].compareTo(datos[i + 1]) > 0) {
                    System.out.println("Cambio " + i + " por " + (i + 1));
                    auxiliar = datos[i + 1];
                    datos[i + 1] = datos[i];
                    datos[i] = auxiliar;
                    System.out.println(Arrays.toString(datos));

                }
            }
        }
    }

    private static void insercion(String[] datos) {
        int i;
        String temp;
        for (int elementoAInsertar = 1; elementoAInsertar < datos.length; elementoAInsertar++) {
            System.out.println("Pasada " + elementoAInsertar);
            System.out.println(Arrays.toString(datos));
            temp = datos[elementoAInsertar];
            int dondeInsertar = 0;
            while (datos[dondeInsertar].compareTo(temp) < 0) {
                dondeInsertar++;
            }
            if (dondeInsertar < elementoAInsertar) {
                System.out.println("Inserto " + temp + " en posición " + dondeInsertar);
                for (i = elementoAInsertar; i > dondeInsertar; i--) {
                    datos[i] = datos[i - 1];
                }
                datos[dondeInsertar] = temp;
            }
        }
    }

    private static void seleccion(String[] datos) {
        int posMenor;
        String aux;
        for (int elemento = 0; elemento < (datos.length - 1); elemento++) {
            posMenor = elemento;
            System.out.println("Pasada " + elemento);
            System.out.println(Arrays.toString(datos));

            for (int i = elemento + 1; i < datos.length; i++) {
                if (datos[i].compareTo(datos[posMenor]) < 0) {
                    posMenor = i;
                }
            }
            System.out.println("Cambio " + datos[elemento] + " por " + datos[posMenor]);
            aux = datos[elemento];
            datos[elemento] = datos[posMenor];
            datos[posMenor] = aux;
        }
    }
}
