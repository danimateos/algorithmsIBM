/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5;

/**
 *
 * @author dani
 */
public class EnumExample {
    
    private enum DedosDeLaMano {INDICE, ANULAR}
    private DedosDeLaMano dedo;

    public EnumExample(DedosDeLaMano dedo) {
        this.dedo = dedo;
    }
    
    public static void main(String[] args) {
        new EnumExample(DedosDeLaMano.INDICE);
    }
    

    
}
