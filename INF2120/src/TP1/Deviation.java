package TP1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//GCCAAUUCCACGUCGUAU    -   test 1
//AAUUCGGCGACAGCCUGGUCCUAC  -   test 2
public class Deviation {
    /**
     *
     * Methode qui prend deux tableaux d'acides et une deviation maximale et choisit la methode appropriee pour
     * calculer la deviation totale.
     *
     * @param s Tableau d'acides
     * @param t Tableau d'acides
     * @param m deviation maximale
     * @return La deviation totale
     */
    public static int getDeviation (ArrayList<Acides> s, ArrayList<Acides> t, int m) {
        int deviation;

        if (s.size() >= t.size()) {
            deviation = fouilleInv(s,t,m);
        } else {
            deviation = fouille(s,t,m);
        }

        return deviation;
    }

    /**
     *
     * Methode qui calcule la deviation totale lorsque le premier tableau est plus court que le deuxieme.
     *
     * @param t1 Un tableau d'acides
     * @param t2 Un tableau d'acides
     * @param dev La deviation maximale
     * @return La deviation totale
     */
    public static int fouilleInv(ArrayList<Acides> t1, ArrayList<Acides>t2, int dev) {
        int deviation = 0;
        int indiceAcide2 = 0;

        for (int i = 0; i < t2.size(); ++i) {
            if (t1.contains(t2.get(i))) {
                for (int j = 0; j < t1.size(); ++j) {


                    if (t1.get(j) == t2.get(i)) {
                        if (j == 0 || Math.abs( j - i) <= indiceAcide2) {
                            indiceAcide2 = Math.abs(j - i);
                        }
                        if (indiceAcide2 > dev) {
                            indiceAcide2 = dev;
                        }
                    }
                    deviation = deviation + indiceAcide2;
                }
            } else {
                deviation = deviation + dev;
            }
        }
        return deviation;
    }

    /**
     *
     * Methode qui calcule la deviation totale en fonction du deuxieme tableau qui est plus court que
     * le premier tableau fourni en parametre.
     *
     * @param t1 Un tableau d'acides
     * @param t2 Un tableau d'acides
     * @param dev La deviation maximale
     * @return La deviation totale
     */
    public static int fouille(ArrayList<Acides> t1, ArrayList<Acides>t2, int dev) {
        int deviation = 0;
        int indiceAcide2 = 0;

        for (int i = 0; i < t1.size(); ++i) {
            if (t2.contains(t1.get(i))) {
                for (int j = 0; j < t2.size(); ++j) {

                    if (t2.get(j) == t1.get(i)) {
                        if (j == 0 || Math.abs( j - i) <= indiceAcide2) {
                            indiceAcide2 = Math.abs(j - i);
                        }
                        if (indiceAcide2 > dev) {
                            indiceAcide2 = dev;
                        }
                    }
                    deviation = deviation + indiceAcide2;
                }
            } else {
                deviation = deviation + dev;
            }
        }


        return deviation;
    }



    /**
     * Methode qui pondere la deviation avec les valeurs recus en parametre a l'aide de la formule
     * <code> v/(m(m+n)*d)</code>.
     *
     * @param v La deviation totale des acides amines.
     * @param m La grandeur de la premiere sequence d'acides amines .
     * @param n La grandeur de la deuxieme sequence d'acides amines.
     * @param d La deviation maximale toleree.
     * @return Un double avec la deviation ponderee.
     */
    public static double ponderer (double v, double m, double n, double d) {
        return (v/((m+n)*d));
    }

    /**
     * Methode qui calcule la similarite entre les deux sequences d'acides amines.
     *
     * @param deviation La deviation obtenue apres la ponderation du resultat.
     * @return Un double avec la similarite entre les deux acides amines. Ceci est le resultat final.
     */
    public static double similarite(double deviation) {
        return Math.exp(-6*deviation*deviation);
    }

}

