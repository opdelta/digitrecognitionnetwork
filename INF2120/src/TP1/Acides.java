package TP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    ILE("AUU", "AUC", "AUA"),
    LEU("UUA", "UUG", "CUU", "CUC", "CUA", "CUG"),
    LYS("AAA", "AAG"),
    MET("AUG"),
    PHE("UUU", "UUC"),
    PRO("CCU", "CCC", "CCA", "CCG"),
    PYL("UAG"),
    SEC("UGA"),
    SER("UCU", "UCC", "UCA", "UCG", "AGU", "AGC"),
    THR("ACU", "ACC", "ACA", "ACG"),
    TRP("UGG"),
    TYR("UAU", "UAC"),
    VAL("GUU", "GUC", "GUA", "GUG"),
    Fin("UUA");

    private final List<String> codons;

    /**
     * Constructeur qui construit une liste contenant les acides aminees des codons.
     * L'argument «String...» est variable (varargs) permettant de prendre un nombre inconnu de chaines
     * pour definir les differents acides.
     *
     * @param codons Une chaine de codons compose de trois lettres majuscules ACGU pour definir un acide amine.
     */
    Acides(String... codons) {
        this.codons = Arrays.asList(codons);
    }

    /**
     * Getter qui retourne les codons d'un certain acide amine dans une liste.
     *
     * @return Une liste contenant les codons de l'acide amine.
     */
    public List<String> getCodons() {

        return codons;
    }

    /**
     * Methode qui fouille la liste des acides amines construite et qui permet de trouver un acide amine
     * en lui fournissant une chaine de codons quelconque.
     *
     * @param nomCodons une chaine de 3 lettres majuscules ACGU qui represente un codon.
     * @return Le nom de l'acide trouvé, null sinon.
     */
    public static Acides trouverAcide(String nomCodons) {
        Acides acideTrouve = null;
        for (Acides acides : Acides.values()) {
            if (acides.getCodons().contains(nomCodons)) {
                acideTrouve = acides;
            }
        }
        return acideTrouve;
    }

    /**
     * Methode qui fouille une sequence de codons donnee en parametre et qui retourne un tableau
     * contenant les acides amines de chaque sequence de 3 codons fournis.
     *
     * @param chaineCodons Une chaine de codons divisible par 3 contenant les lettres majuscules ACGU.
     * @return Un ArrayList des codons transformes en acides amines.
     */
    public static ArrayList<Acides> sequenceToArray(String chaineCodons) {
        ArrayList tableauCodons = new ArrayList<>();
        int longueurChaine = chaineCodons.length();
        for (int i = 0; i < longueurChaine / 3; i++) {
            tableauCodons.add(trouverAcide(chaineCodons.substring(3 * i, 3 * (i + 1))));
        }
        return tableauCodons;
    }

}