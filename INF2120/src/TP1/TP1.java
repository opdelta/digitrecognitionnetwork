package TP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * -> Classes.
 * -> ArrayList
 * -> methode:
 *      commentee:
 *      description de la methode.
 *      decription des arguments (role).
 *      description des sorties.
 *      description des exceptions.
 *      -> for, while, if, switch, try <= 7.
 *      -> return <= 1
 *      -> continue == 0
 *      break :: dans un switch seulement.
 *
 *
 * Lire 3 entrees
 * 1 - Chaine de caracteres ARN (a1) Nucleotide : ACGU
 * 2 - Chaine de caracteres ARN (a2) Nucleotide : ACGU
 * 3 - nombre entier (m) > 0
 *
 * transformer en sequence acide amine les nucleotides.
 * 3 nucleotides (codons) -> acide amine. (Divisible par 3).
 * a1 -> s1 (ArrayList)
 * a2 -> s2 (ArrayList)
 *
 * Calcul des differences.
 *
 * Pour tout acide acide amine (i) dans s1
 *  Trouver le distance du meme acide amine la plus proche dans s2.
 *  Faire la somme des distances.
 * Pour tout acide amine (j) dans s2
 *  Trouver la distance du meme acide amine la plus proche dans s1.
 *  Faire la somme des distances.
 *
 * Exemple: s1 - V A B K A R && s2 - V K A B B S
 * Distance de A = 1. (A dans s1 = ind. 1 && A dans s2 = ind. 2)
 * Distance de V = 0.
 * Distance de B = 1.
 * Distance de K = 2.
 * Distance de R = inf. -> m ex. 3.
 * Distance total = 0 + 1 + 1 + 2 + 2 + 3  = 9.
 */

public class TP1 {
    public static final String CHAINE1 = "Chaine 1 : ";
    public static final String CHAINE2 = "Chaine 2 : ";
    public static final String DEVIATION = "Deviation maximale : ";
    public static final String SIMILAR = "Similarite";
    public static final String ERR_TROIS = "Erreur: Votre chaine doit contenir un nombre de lettres divisible par trois. Veuillez recommencer.";
    public static final String ERR_LETTRES = "Erreur: Votre chaine doit contenir UNIQUEMENT les lettres A,C,G,U en majuscule. Veuillez recommencer.";
    public static final String ERR_DEVIATION = "Erreur: Votre deviation doit etre superieure a 0. Veuillez recommencer.";

    public static void verifierChaine (String chaine) throws LettresInvalides, NombreDeLettresInvalide {
        boolean valide = true;
        try {
            for (int i = 0; i < chaine.length(); ++i) {
                if (chaine.charAt(i) != 'A' && chaine.charAt(i) != 'C' && chaine.charAt(i) != 'G' && chaine.charAt(i) != 'U') {
                    valide = false;
                }
            }
            if (!valide) {
                throw new LettresInvalides(ERR_LETTRES);
            }
            if (chaine.length() % 3 != 0) {
                throw new NombreDeLettresInvalide(ERR_TROIS);
            }
        } catch (LettresInvalides e) {
            System.out.println(ERR_LETTRES);
            System.exit(-1);
        } catch (NombreDeLettresInvalide e) {
            System.out.println(ERR_TROIS);
            System.exit(-2);
        }
    }



    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\n" + CHAINE1);
            String s1 = sc.next();
            verifierChaine(s1);
            System.out.print("\n" + CHAINE2);
            String s2 = sc.next();
            verifierChaine(s2);
            System.out.print("\n" + DEVIATION);
            int m = sc.nextInt();
            if (m <= 0) {
                throw new NumberFormatException();
            }
            sc.close();
        } catch (LettresInvalides e) {
            System.exit(-1);
        } catch (NombreDeLettresInvalide e) {
            System.exit(-2);
        }catch (NumberFormatException e) {
            System.out.println(ERR_DEVIATION);
                System.exit(-3);
        }
    }
}



