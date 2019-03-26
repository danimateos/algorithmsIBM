/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenParcial2019;

import java.util.Random;

/**
 *
 * @author dani
 */
public class Experiment {
    String nullHypothesis;
    Float pvalue;
    Sample[] samples;
    Assay assay;

    public Experiment(String nullHypothesis, Sample[] samples, Assay assay) {
        this.nullHypothesis = nullHypothesis;
        this.samples = samples;
        this.assay = assay;
    }
            
    public void perform() {
        this.pvalue = new Random().nextFloat();
    }
    
    public Boolean wasSuccesful(float significance){
        return (this.pvalue < significance);    
    }
    
    public float totalCost(){
        return this.assay.cost * this.samples.length;   
    }
}
