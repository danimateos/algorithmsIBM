/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.mice;

import java.time.LocalDate;

/**
 *
 * @author dani
 */
public class Mouse {

    private String reference, comments;
    private LocalDate birthDate;
    private Gender gender;
    private int weight;
    private float temperature;
    private boolean chrom1, chrom2;

    public Mouse(String reference, LocalDate birthDate, Gender gender, int weight, float temperature, boolean chrom1, boolean chrom2, String comments) {
        this.reference = reference;
        this.comments = comments;
        this.birthDate = birthDate;
        this.gender = gender;
        this.weight = weight;
        this.temperature = temperature;
        this.chrom1 = chrom1;
        this.chrom2 = chrom2;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public boolean isChrom1() {
        return chrom1;
    }

    public void setChrom1(boolean chrom1) {
        this.chrom1 = chrom1;
    }

    public boolean isChrom2() {
        return chrom2;
    }

    public void setChrom2(boolean chrom2) {
        this.chrom2 = chrom2;
    }

    @Override
    public String toString() {
        return "Mouse " + reference + ", born on " + birthDate + " " + gender + " " + phenotype() + weight + "g, " + temperature + " degrees C. Additional information: " + comments;
    }

    public String phenotype() {
        String phenotype = "";

        if (gender == Gender.FEMALE) {
            if (chrom1 && chrom2) {
                phenotype = "Sterile";
            } else {
                phenotype = "Wild type";
            }
        } else {
            if (chrom1) {
                phenotype += "Sterile ";
            }
            if (chrom2) {
                phenotype += "Polygamous";
            }
            if (!chrom1 && !chrom2) {
                phenotype = "Wild type";
            }
        }

        return phenotype;
    }
    
    public String toLine(){
        String line = "";
        
        String[] props = {reference, 
                          birthDate.toString(), 
                          gender.toString(), 
                          Boolean.toString(chrom1), 
                          Boolean.toString(chrom2),
                          Integer.toString(weight),
                          Float.toString(temperature),
                          comments};
        
        for (String prop : props) {
            line += prop + "|";
        }
        
        return line;
        
    }
    
    
}
