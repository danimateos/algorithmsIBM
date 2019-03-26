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
public class Date {

    private int year, month, day;

    public Date(int year, int month, int day) {
        this.year = year;
        checkDayMonth(month, day);
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public void checkDayMonth(int month, int day){
    
        if (month > 12) {
            throw new RuntimeException("Month is over 12");
        } else if (month == 2 && day > 28){
        
            throw new RuntimeException("February...");
        }
    
    
    }
    
    @Override
    public String toString() {
        return "" + year + "/" + month + "/" + day;
    }
}
