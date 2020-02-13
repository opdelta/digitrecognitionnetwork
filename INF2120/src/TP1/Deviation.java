package TP1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//GCCAAUUCCACGUCGUAU    -   test 1
//AAUUCGGCGACAGCCUGGUCCUAC  -   test 2
public class Deviation {


    public static int f(ArrayList<Acides> t1, ArrayList<Acides> t2, int dev){
        int deviation = 0;
        for ( int i = 0; i < t1.size(); ++i) {
            if(t2.contains(t1.get(i))) {
                for (int j = 0; j < t2.size(); ++j) {
                    if (Math.abs(i-j) <= dev) {
                        deviation = deviation + Math.min(Math.min(Math.abs(i-j), t2.indexOf(t1.get(i))), Math.min(Math.abs(i-j), t1.indexOf(t2.get(j))));
                    } else {
                        deviation = deviation + Math.min(Math.min(Math.abs(i-j), dev), Math.min(Math.abs(i-j), dev));
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
     * @param t1
     * @param t2
     * @param dev
     * @return
     */
    public static int fouille(ArrayList<Acides> t1, ArrayList<Acides> t2, int dev) {
        int deviation = 0;
        int deviationT = 0;
        Acides acide;
        ArrayList intJ = new ArrayList<Integer>();
        ArrayList correspondances = new ArrayList<String>();
        ArrayList deviationInt = new ArrayList<Integer>();

        for (int i = 0; i < t1.size(); ++i) {
            if (t2.contains(t1.get(i))) {
                for (int j=0;j<t2.size();++j){
                    if (t1.get(i) == t2.get(j)) {
                        acide = t1.get(i);
                        correspondances.add("t1["+i+"], t2["+j+"]");
                        deviationInt.add(Math.abs(j-i));
                        intJ.add(j);

                    }
                }
            } else {
                deviation = deviation + dev;
            }

        }
        for( int k = 0; k<correspondances.size(); ++k) {
            System.out.println(correspondances.get(k) + " = " + deviationInt.get(k) + " indices = " + intJ.get(k));
        }

        return deviation;
    }

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

