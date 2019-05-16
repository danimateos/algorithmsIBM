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
class Mano {
    
    public enum Postura{ABIERTA, AGARRE_FUERZA, AGARRE_PRECISION}
    
    private Postura posturaActual;

    public Mano() {
        this.posturaActual = Postura.ABIERTA;
    }
    
    public String toString (){
        return this.posturaActual.toString();
    }
    
}
