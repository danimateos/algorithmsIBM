/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema6;

/**
 *
 * @author dani
 */
public class HashCodeExample {
    String contenido;

    public HashCodeExample(String contenido) {
        this.contenido = contenido;
    }
    
    
    
    
    @Override
    public int hashCode(){
        return contenido.charAt(0);
    }
}
