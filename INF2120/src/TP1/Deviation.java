package TP1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//GCCAAUUCCACGUCGUAU    -   test 1
//AAUUCGGCGACAGCCUGGUCCUAC  -   test 2
public class Deviation {


    public static int test(ArrayList<Acides> t1, ArrayList<Acides>t2, int dev) {
        int deviation = 0;
        Acides acide1;
        int acide2;
        int indiceAcide2;
        int indiceAcide1;
        int longt1 = Math.max(t1.size(), t2.size());

        for (int i = 0; i < t1.size(); ++i) {
            acide1 = t1.get(i);
            indiceAcide1 = i;
            if (t2.contains(acide1)) {
                for (int j = 0; j < t2.size(); ++j) {
                    indiceAcide2 = j;
                    if (t2.get(j) == acide1) {
                        acide2 = j;
                        if (acide2 - indiceAcide1 <= indiceAcide2) {
                            if (Math.abs(indiceAcide2 - indiceAcide1) > dev) {
                                deviation = deviation + dev;
                            } else {
                                deviation = deviation + Math.abs(indiceAcide2 - indiceAcide1);
                            }
                        }

                    }
                }
            } else {
                deviation = deviation + dev;
            }
        }

        return deviation;
    }



    /**
     * Methode qui pondere la deviation avec les valeurs recus en parametre.
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

    /**
     * Methode qui fouille deux tableaux d'acides amines et calcule la similarite entre les deux.
     * @param premierTableau
     * @param deuxiemeTableau
     * @param deviationMaximale
     * @return
     */
    public static int fouilleTableau(ArrayList<Acides> premierTableau, ArrayList<Acides> deuxiemeTableau, int deviationMaximale) {
        int deviationTrouvee = 0;
        int deviationTotale = 0;
        for (int i = 0; i < premierTableau.size(); ++i) {
            if (deuxiemeTableau.contains(premierTableau.get(i))) {
                for (int j = 0; j < deuxiemeTableau.size(); ++j) {
                    if (deuxiemeTableau.get(j) == premierTableau.get(i)) {
                        deviationTrouvee = Math.abs(i - j);
                    }
                    if (Math.abs(deviationTrouvee) > deviationMaximale) {
                        deviationTrouvee = deviationMaximale;
                    }
                    deviationTotale = (deviationTotale + deviationTrouvee);

                }
            } else {
                deviationTotale = deviationTotale + deviationMaximale;
            }
            deviationTrouvee = 0;
        }
        return deviationTotale;
    }
    public static int fouilleTableauInverse(ArrayList<Acides> premierTableau, ArrayList<Acides> deuxiemeTableau, int deviationMaximale) {
        int deviationTrouvee = 0;
        int deviationTotale = 0;
        for (int i = 0; i < deuxiemeTableau.size(); ++i) {
            if (premierTableau.contains(deuxiemeTableau.get(i))) {
                for (int j = 0; j < premierTableau.size(); ++j) {
                    if (premierTableau.get(j) == deuxiemeTableau.get(i)) {
                        deviationTrouvee = Math.abs(i - j);
                    }
                    if (deviationTrouvee > deviationMaximale) {
                        deviationTrouvee = deviationMaximale;
                    }
                    deviationTotale = (deviationTotale + deviationTrouvee);
                }
            } else {
                deviationTotale = deviationTotale + deviationMaximale;
            }
        }
        return (deviationTotale);
    }


    public static int deviationTotale(ArrayList<Acides> premierTableau, ArrayList<Acides> deuxiemeTableau, int deviationMaximale) {
        int deviationTotale = 0;
        if (premierTableau.size() < deuxiemeTableau.size()) {
            deviationTotale = fouilleTableau(premierTableau, deuxiemeTableau, deviationMaximale);
        } else {
            deviationTotale = fouilleTableauInverse(premierTableau, deuxiemeTableau, deviationMaximale);
        }

        return deviationTotale;
    }
}

