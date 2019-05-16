/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenParcial2019;

import java.util.Arrays;

/**
 *
 * @author dani
 */
public class Brazo {
    private Articulacion hombro, codo, muneca;
    private Mano mano;
    
    public Brazo(){
        this.hombro = new Articulacion();
        this.codo = new Articulacion();
        this.muneca = new Articulacion();
        this.mano = new Mano();
    }
    
    public Brazo(String repr){
        this();
        String[] state = repr.split(";");
        String[] hombro = state[0].split("\\|");
        this.hombro.setFlexoextension(Float.parseFloat(hombro[0]));
        this.hombro.setRotacion(Float.parseFloat(hombro[1]));
        String[] codo = state[1].split("\\|");
        this.codo.setFlexoextension(Float.parseFloat(codo[0]));
        this.codo.setRotacion(Float.parseFloat(codo[1]));
        String[] muneca = state[2].split("\\|");
        this.muneca.setFlexoextension(Float.parseFloat(muneca[0]));
        this.muneca.setRotacion(Float.parseFloat(muneca[1]));
    }
    
    public String toString(){
        String texto = this.hombro.toString() + ";" + 
                       this.codo.toString() + ";" + 
                       this.muneca.toString() + ";" + 
                       this.mano.toString();
        
        return texto;
    }
    
    public static void main(String[] args) {
        Brazo brazo = new Brazo();
        brazo.codo.setFlexoextension(0.5f);
        brazo.muneca.setRotacion(0.5f);
        String state = brazo.toString();
        System.out.println(state);
        
        Brazo copia = new Brazo(state);
        System.out.println(copia);
    }
    
    
}
