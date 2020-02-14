/**
 * Programme qui permet de comparer deux acides ribonucléiques (ARN) en retournant la similarite entre les deux ARNs
 * fournis en parametre.
 *
 * @author Ziad Lteif
 * @version Fevrier 2020
 * @CodePermanent LTEZ18059802
 */

package TP1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TP1 {
    public static final String CHAINE1 = "Chaine 1 : ";
    public static final String CHAINE2 = "Chaine 2 : ";
    public static final String DEVIATION = "Deviation maximale : ";
    public static final String SIMILAR = "Similarite : ";
    public static final String ERR_TROIS = "Erreur: La chaine doit contenir un nombre de lettres divisible par trois. Veuillez recommencer.";
    public static final String ERR_LETTRES = "Erreur: La chaine doit contenir que les lettres \"A,C,G,U\" en majuscule. Veuillez recommencer.";
    public static final String ERR_DEVIATION = "Erreur: La deviation doit etre un chiffre superieur a 0. Veuillez recommencer.";
    public static final String ERR_AUTRE = "Erreur: Un probleme imprevu est survenu. Veuillez recommencer.";
    /**
     * Methode qui verifie si une chaine entree est valide ou non.
     *
     * @param chaine Une chaine quelconque.
     * @throws LettresInvalides Si la chaine n'a pas les lettres ACGU en majuscule uniquement, l'exception est lancee.
     * @throws NombreDeLettresInvalide Si la chaine n'a pas un nombre de lettres divisible par trois, l'exception est lancee.
     */
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
            System.err.println(ERR_LETTRES);
            System.exit(-1);
        } catch (NombreDeLettresInvalide e) {
            System.err.println(ERR_TROIS);
            System.exit(-2);
        }
    }


    public static void main(String[] args) {
        String s1;  //Information to explain
        ArrayList<Acides> s = new ArrayList<>(); //Information to explain
        ArrayList<Acides> t = new ArrayList<>(); //Information to explain
        String s2;  //Information to explain
        int m;  //Information to explain
        double deviationPonderee;
        double deviation;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\n" + CHAINE1);
            s1 = sc.next();
            verifierChaine(s1);
            s = Acides.sequenceToArray(s1);

            System.out.print("\n" + CHAINE2);
            s2 = sc.next();
            verifierChaine(s2);
            t = Acides.sequenceToArray(s2);

            System.out.print("\n" + DEVIATION);
            m = sc.nextInt();
            if (m <= 0) {
                throw new NumberFormatException();
            }
            sc.close();
            deviation = Deviation.getDeviation(s,t,m);
            deviationPonderee = Deviation.ponderer(deviation, s.size(), t.size(), m);

            System.out.println(SIMILAR + Deviation.similarite(deviationPonderee));

        } catch (LettresInvalides e) {
            System.exit(-1);
        } catch (NombreDeLettresInvalide e) {
            System.exit(-2);
        }catch (NumberFormatException e) {
            System.err.println(ERR_DEVIATION);
                System.exit(-3);
        }catch (InputMismatchException e) {
            System.err.println(ERR_DEVIATION);
            System.exit(-4);
        } catch (Exception e) {
            System.err.println(ERR_AUTRE);
            System.exit(-5);
        }

    }
}



