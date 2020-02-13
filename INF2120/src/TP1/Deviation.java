package TP1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

//GCCAAUUCCACGUCGUAU
//AAUUCGGCGACAGCCUGGUCCUAC
public class Deviation {

    public static int fouille(ArrayList<Acides> t1, ArrayList<Acides> t2, int dev) {
        int deviation = 0;

        for (int i = 0; i < t1.size(); ++i) {
            if (t2.contains(t1.get(i))) {
                for (int j = 0; j < t2.size(); j++) {
                    System.out.println("i = " + i + " et j = " + j);
                    if (t1.get(i) == t2.get(j)) {
                        if (Math.abs(i - j) > dev) {
                            deviation = deviation + dev;
                        } else {
                            deviation = deviation + Math.abs(i - j);
                        }
                    }
                }
            } else {
                deviation = deviation + dev;
            }

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
        }
        return Math.abs(deviationTotale);
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

