/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenFinal2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dani
 */
public class ClasesYManejoErrores {

    public static void main(String[] args) {
        Sequence dna = null, rna = null, prot = null;

        try {
            prot = new Sequence("KIHL", Molecule.PROTEIN);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            rna = new Sequence("AGGAGAUAUCUCUCUAUUUAAAAAA", Molecule.RNA);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        try {
            dna = new Sequence("AAGTCGATCGCATCGATCAGACTA", Molecule.DNA);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        System.out.println(dna.toString() + "\n" + rna.toString() + "\n" + prot.toString());

        List<Sequence> seqs = new ArrayList();

        seqs.add(dna);
        seqs.add(prot);
        seqs.add(rna);

        Collections.sort(seqs);
        System.out.println(seqs);

        Collections.sort(seqs, new Comparators.LongToShort());
        System.out.println(seqs);

        Collections.sort(seqs, new Comparators.ShortToLong());
        System.out.println(seqs);
        
    }
}

/*  Ejercicio: convertir esta clase en abstracta para diferenciar proteinas, 
    rnas, y dnas.  Describir qué atributos se quedarían tal cual en la clase
    abstracta y cuáles cambiarían de nombre, o bajarían a las clases hijas. Qué 
    métodos estarían en cada una de las clases hijas. Escribir un método toString
    que funcione tanto para la clase base como para las hijas.
 */
class Sequence implements Comparable<Sequence> {

    static final String DNA_ALPHABET = "AGCT";
    static final String RNA_ALPHABET = "AGCU";
    static final String PROTEIN_ALPHABET = "ARNDCQEGHILKMFPSTWYV";

    String alphabet;
    Molecule molecule;
    String letters;
    int length;

    public Sequence(String letters, Molecule molecule) {
        this.molecule = molecule;
        if (this.molecule == Molecule.DNA) {
            this.alphabet = DNA_ALPHABET;
        } else if (this.molecule == Molecule.RNA) {
            this.alphabet = RNA_ALPHABET;
        } else if (this.molecule == Molecule.PROTEIN) {
            this.alphabet = PROTEIN_ALPHABET;
        }

        // Ejercicio: intoducir este bloque para controlar que las secuencias tengan sentido.
        for (int i = 0; i < letters.length(); i++) {
            if (!this.alphabet.contains(letters.substring(i, i + 1))) {
                throw new IllegalArgumentException("Symbol " + letters.charAt(i)
                        + " is not one of the valid symbols for a "
                        + this.molecule + " molecule.");
            }
        }

        this.letters = letters;
        this.length = letters.length();
    }

    // Ejercicio: escribir este metodo y el comparador externo.
    @Override
    public int compareTo(Sequence other) {
        return this.letters.compareTo(other.letters);
    }

    // Ejercicio: escribir este método y el siguiente
    public Sequence transcribe() {
        if (this.molecule != Molecule.DNA) {
            throw new UnsupportedOperationException("Only DNA can be transcribed");
        }

        Map<String, String> codeTable = Maps.transcriptionCode;

        String resultingSequence = "";
        for (int i = 0; i < this.letters.length(); i++) {
            String codon = this.letters.substring(i, i + 1);
            String aa = codeTable.get(codon);
            resultingSequence += aa;
        }
        return new Sequence(resultingSequence, Molecule.RNA);
    }

    // Ejercicio: escribir este método
    public Sequence translate() {
        if (this.molecule != Molecule.RNA) {
            throw new UnsupportedOperationException("Only RNA can be translated");
        }
        Map<String, String> codeTable = Maps.geneticCode;

        String resultingSequence = "";
        for (int i = 0; i < this.letters.length(); i += 3) {
            String codon = this.letters.substring(i, i + 3);
            String aa = codeTable.get(codon);
            resultingSequence += aa;
        }
        return new Sequence(resultingSequence, Molecule.PROTEIN);

    }

    @Override
    public String toString() {
        return this.molecule + " molecule with sequence " + this.letters;
    }

}

enum Molecule {
    DNA, RNA, PROTEIN
}

abstract class Comparators {
// Ejercicio: implement this external comparator. Bonus: Don't use any if.

    static class LongToShort implements Comparator<Sequence> {

        @Override
        public int compare(Sequence t1, Sequence t2) {
            return t2.length - t1.length;
        }

    }

    static class ShortToLong implements Comparator<Sequence> {

        @Override
        public int compare(Sequence t1, Sequence t2) {
            return t1.length - t2.length;
        }

    }
}
