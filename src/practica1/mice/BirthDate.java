/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.mice;

/**
 *
 * @author dani
 */
public class BirthDate {

    int day, month, year;

    public BirthDate(int day, int month, int year) throws Exception {

        if (day < 1 || day > 31) {
            throw new Exception("Not a valid day");
        } else if (month < 1 || month > 12) {
            throw new Exception("Not a valid month");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static void main(String[] args) {

        boolean validDate = false;
        while (!validDate) {
            try {
                BirthDate date = new BirthDate(55, 12, 1987);
                validDate = true;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

}
