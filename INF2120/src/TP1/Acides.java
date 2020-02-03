package TP1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public enum Acides {
    ALA("GCU","GCC","GCA","GCG"),
    ARG("CGU","CGC","CGA","CGG","AGA","AGG"),
    ASN("AAU","AAC"),
    ASP("GAU","GAC"),
    CYS("UGU","UGC"),
    GLU("GAA","GAG"),
    GLN("CAA","CAG"),
    GLY("GGU","GGC","GGA","GGG"),
    HIS("CAU","CAC"),
    ILE("AAU","AUC","AUA"),
    LEU("UUA","UUG","CUU","CUC","CUA","CUG"),
    LYS("AAA","AAG"),
    MET("AUG"),
    PHE("UUU","UUC"),
    PRO("CCU","CCC","CCA","CCG"),
    PYL("UAG"),
    SEC("UGA"),
    Ser("UCU","UCC","UCA","UCG","AGU","AGC"),
    THR("ACU","ACC","ACA","ACG"),
    TRP("UGG"),
    TYR("UAU","UAC"),
    VAL("GUU","GUC","GUA","GUG"),
    Fin("UUA");

    private String _premierCodon;
    private String _deuxiemeCodon;
    private String _troisiemeCodon;
    private String _quatriemeCodon;
    private String _cinquiemeCodon;
    private String _sixiemeCodon;

    private Acides(String premierCodon) {
        _premierCodon = premierCodon;
    }
    private Acides(String premierCodon, String deuxiemeCodon) {
        _premierCodon = premierCodon;
        _deuxiemeCodon = deuxiemeCodon;
    }
    private Acides(String premierCodon, String deuxiemeCodon, String troisiemeCodon) {
        _premierCodon = premierCodon;
        _deuxiemeCodon = deuxiemeCodon;
        _troisiemeCodon = troisiemeCodon;
    }
    private Acides(String premierCodon, String deuxiemeCodon, String troisiemeCodon, String quatriemeCodon) {
        _premierCodon = premierCodon;
        _deuxiemeCodon = deuxiemeCodon;
        _troisiemeCodon = troisiemeCodon;
        _quatriemeCodon = quatriemeCodon;
    }
    private Acides(String premierCodon, String deuxiemeCodon, String troisiemeCodon, String quatriemeCodon, String cinquiemeCodon) {
        _premierCodon = premierCodon;
        _deuxiemeCodon = deuxiemeCodon;
        _troisiemeCodon = troisiemeCodon;
        _quatriemeCodon = quatriemeCodon;
        _cinquiemeCodon = cinquiemeCodon;
    }
    private Acides(String premierCodon, String deuxiemeCodon, String troisiemeCodon, String quatriemeCodon, String ciquiemeCodon, String sixiemeCodon) {
        _premierCodon = premierCodon;
        _deuxiemeCodon = deuxiemeCodon;
        _troisiemeCodon = troisiemeCodon;
        _quatriemeCodon = quatriemeCodon;
        _cinquiemeCodon = ciquiemeCodon;
        _sixiemeCodon = sixiemeCodon;
    }


}
