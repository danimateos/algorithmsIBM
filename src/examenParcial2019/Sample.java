/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenParcial2019;

/**
 *
 * @author dani
 */
public class Sample {
    Organism organism;
    String tissue;
    float amountMicrograms;

    public Sample(Organism organism, String tissue, float amountMicrograms) {
        this.organism = organism;
        this.tissue = tissue;
        this.amountMicrograms = amountMicrograms;
    }
    
    public Sample[] aliquot(int numSamples) {
        Sample[] results = new Sample[numSamples];
        
        for (int i =0; i < numSamples; i++){
            results[i] = new Sample(this.organism, this.tissue, this.amountMicrograms / numSamples);
        }
        
        return results;
    }
    
           
}
