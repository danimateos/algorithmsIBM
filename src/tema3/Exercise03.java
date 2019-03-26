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
public class Exercise03 {

    public static void main(String[] args) {
        Rational a = new Rational(2, 4);
        Rational b = new Rational(3, 8);
        System.out.println(a.add(b));
        System.out.println(a.add(b).simplified());
        System.out.println(a.times(b));
        System.out.println(a.times(b).simplified());
        System.out.println(a.dividedBy(b));
        System.out.println(a.dividedBy(b).simplified());

    }

}

class Rational {

    int numerator, denominator;

    Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Rational() {
        this(1, 1);
    }

    Rational(Rational original) {
        this(original.numerator, original.denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Rational add(Rational other) {
        int numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;

        return new Rational(numerator, denominator);
    }

    public Rational times(Rational other) {
        return new Rational(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Rational dividedBy(Rational other) {
        int numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;

        return new Rational(numerator, denominator);
    }

    public Rational simplified() {
        int divisor = gcd(this.numerator, this.denominator);
        return new Rational(this.numerator / divisor, this.denominator / divisor);
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    @Override
    public String toString() {
        return String.format("%d / %d", this.numerator, this.denominator);
    }
}
