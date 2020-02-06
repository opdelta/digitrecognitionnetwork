package TP1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public enum Acides {
    ALA("GCU", "GCC", "GCA", "GCG"),
    ARG("CGU", "CGC", "CGA", "CGG", "AGA", "AGG"),
    ASN("AAU", "AAC"),
    ASP("GAU", "GAC"),
    CYS("UGU", "UGC"),
    GLU("GAA", "GAG"),
    GLN("CAA", "CAG"),
    GLY("GGU", "GGC", "GGA", "GGG"),
    HIS("CAU", "CAC"),
    ILE("AAU", "AUC", "AUA"),
    LEU("UUA", "UUG", "CUU", "CUC", "CUA", "CUG"),
    LYS("AAA", "AAG"),
    MET("AUG"),
    PHE("UUU", "UUC"),
    PRO("CCU", "CCC", "CCA", "CCG"),
    PYL("UAG"),
    SEC("UGA"),
    Ser("UCU", "UCC", "UCA", "UCG", "AGU", "AGC"),
    THR("ACU", "ACC", "ACA", "ACG"),
    TRP("UGG"),
    TYR("UAU", "UAC"),
    VAL("GUU", "GUC", "GUA", "GUG"),
    Fin("UUA");

    private final List<String> codons;

    /**
     * Constructeur qui construit une liste
     *
     * @param codons
     */
    Acides(String... codons) {
        this.codons = Arrays.asList(codons);
    }

    public List<String> getCodons() {
        return codons;
    }

    public static Acides trouverAcide(String name) {
        Acides acideTrouve = null;
        for (Acides acides : Acides.values()) {
            if (acides.getCodons().contains(name)) {
                acideTrouve = acides;
            }
        }
        return acideTrouve;
    }

}




