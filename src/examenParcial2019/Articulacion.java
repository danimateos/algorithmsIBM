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
class Articulacion {
    private float flexoextension, rotacion;

    public Articulacion() {
        this.flexoextension = 0;
        this.rotacion = 0;
    }

    public float getFlexoextension() {
        return flexoextension;
    }

    public void setFlexoextension(float flexoextension) {
        this.flexoextension = flexoextension;
    }

    public float getRotacion() {
        return rotacion;
    }

    public void setRotacion(float rotacion) {
        this.rotacion = rotacion;
    }
    
    public String toString(){
        return this.flexoextension + "|" + this.rotacion;
    }
}
