/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Haz una clase llamada Persona con atributos: nombre, edad, DNI, sexo (usa una
 * enumeración), peso y altura. Crea métodos para acceder y modificar todos los
 * atributos. Por defecto, todos los atributos menos el DNI tendrán valores por
 * defecto según su tipo (0 números, cadena vacía para String, etc.). Sexo será
 * mujer por defecto. La clase deberá tener los siguientes constructores
 * constructores: - Un constructor por defecto. - Un constructor con el nombre,
 * edad y sexo, el resto por defecto. - Un constructor con todos los atributos
 * como parámetro, menos el DNI. La clase deberá tener los siguientes métodos: -
 * calcularIMC(): calcula el índice de masa corporal de la persona (peso en
 * kg/(altura^2 en m)) - valorarPesoCorporal() devuelve un -1 si está por debajo
 * de su peso ideal, un 0 si está en su peso ideal y un 1 si tiene sobrepeso.
 * Sobrepeso se define como IMC > 25 y se considera que se está por debajo del
 * peso ideal si IMC <18. - esMayorDeEdad(): indica si es mayor de edad,
 * devuelve un booleano.Algoritmos y Estructuras de Datos toString(): devuelve
 * toda la información de la persona como una cadena de caracteres. -
 * generaDNI(): genera un numero aleatorio de 8 cifras que será el DNI de la
 * persona. Este método no será visible desde el exterior. Este método deberá
 * invocarse desde cualquier constructor para generar el DNI. - Métodos set de
 * cada parámetro, excepto de DNI. Ahora, crea una clase ejecutable que haga lo
 * siguiente: * - Pide por teclado el nombre, la edad, sexo, peso y altura. -
 * Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores
 * variables pedidas por teclado, el segundo objeto obtendrá todos los
 * anteriores menos el peso y la altura y el último por defecto, para este
 * último utiliza los métodos set para darle a los atributos un valor. - Para
 * cada objeto, se deberá comprobar si está en su peso ideal, tiene sobrepeso o
 * por debajo de su peso ideal con un mensaje. - Indicar para cada objeto si es
 * mayor de edad. - Por último, mostrar la información de cada objeto.
 *
 * @author dani
 */
public class Exercise05 {

    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        
        try {
            System.out.println("Input name, age, gender, height:");
            System.out.println("Name?");
            String name = console.readLine();
            System.out.println("Age?");
            int age = Integer.parseInt(console.readLine());
            System.out.println("Gender?");
            String genderInput = console.readLine();
            Person.Gender gender = Person.Gender.MALE;
            if (genderInput.toLowerCase().contains("f")) {
                gender = Person.Gender.FEMALE;
            }
            System.out.println("Height in cm?");
            float height = Float.parseFloat(console.readLine());
            System.out.println("Weight in kg?");
            float weight = Float.parseFloat(console.readLine());
            
            person1 = new Person(name, age, gender, height, weight);
            person2 = new Person(name, age, gender);
            person3 = new Person();
            person3.setName(name);
            person3.setAge(age);
            person3.setGender(gender);
            person3.setHeight(height);
            person3.setWeight(weight);
            
        } catch (IOException ex) {
            System.out.println("Woops!");
        }
        
        System.out.println("Person 1");
        System.out.println(person1.evalBodyWeight());
        System.out.println(person1.isAdult());
        System.out.println(person1);

        System.out.println("Person 2");
        System.out.println(person2.evalBodyWeight());
        System.out.println(person2.isAdult());
        System.out.println(person2);
        
        System.out.println("Person 3");
        System.out.println(person3.evalBodyWeight());
        System.out.println(person3.isAdult());
        System.out.println(person3);        
    }

    private static class Person {

        private enum Gender {
            MALE, FEMALE
        };

        private float weight, height;
        private int age, DNI;
        private Gender gender;
        private String name;

        public Person() {
            this.weight = 0;
            this.height = 0;
            this.age = 0;
            this.name = "";
            this.DNI = generateDNI();
            this.gender = Gender.FEMALE;
        }

        public Person(String name, int age, Gender gender) {
            this();
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public Person(String name, int age, Gender gender, float height, float weight) {
            this(name, age, gender);
            this.height = height;
            this.weight = weight;
        }

        public double calcBWI() {
            return weight / Math.pow(height, 2);
        }

        public int evalBodyWeight() {
            double bwi = calcBWI();
            if (bwi < 18) {
                return -1;
            } else if (bwi > 25) {
                return 1;
            } else {
                return 0;
            }
        }

        public boolean isAdult() {
            return age > 18;
        }

        @Override
        public String toString() {
            return name + ", " + age + " " + gender + " years old, weighing " + weight + "kilos and " + height + " centimeters tall. DNI" + DNI;
        }

        public int generateDNI() {
            Random random = new Random();
            return Math.abs(random.nextInt() % 100000000);
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
