/**
 * Write a description of class Bibliotheque here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bibliotheque
{
    public static final String MSG_PRES = "Cette application permet d'executer diverses requetes pour rechercher des livres\ndans une bibliotheque donnee. Elle permet plus particulierement de faire des\nrecherches par categorie(s), par expression dans le titre, par auteur, et par\nperiode de publication.\n";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";
    public static final String MENU = "MENU DE RECHERCHE";
    public static final String CHOIX = "1. Recherche par categorie(s) \n2. Recherche par titre\n3. Recherche par auteur\n4. Recherche par periode\n5. Quitter\n";
    public static final String MSG_SOL_CHOIX = "Entrez votre choix : ";
    public static final String MSG_FIN = "AUREVOIR !";
    public static final String MSG_CAT = "*** RECHERCHE PAR CATEGORIE(S) ***";
    public static final String MSG_SOL_CAT = "Recherche par (C)onjonction ou (D)isjonction : ";
    public static final String MSG_ERR_CAT = "Erreur, entrez C ou D ! Recommencez...";
    public static final String LISTE_CAT = "LISTE DES CATEGORIES : \n  1. Science fiction \n   2. Romance \n   3. Thriller \n   4.Policier \n   5. Humeur \n   6. Drame \n";
    public static final String MSG_SOL_NUM_CAT = "Entrez un numero de categorie (0 pour terminer) : ";
    public static final String ERR_CAT = "Erreur, numero de categorie invalide! Recommencez...";
    public static final String ANN_RECH = "RECHERCHE ANNULEE.";
    public static final String REQ = "REQUETE : ";
    public static final String RESULT_RECH = "RESULTAT(S) DE RECHERCHE :";
    public static final String MSG_SOL_ENTREE = "Tapez <ENTREE> pour revenir au menu de recherche...";
    public static final String MSG_RECH_NUL = "AUCUN LIVRE TROUVE.";
    public static final String MSG_TITRE = "*** RECHERCHE PAR TITRE ***";
    public static final String MSG_SOL_TITRE = "Entrez le titre ou une partie du titre (<ENTREE> pour terminer) : ";
    public static final String ERR_TITRE = "Erreur, le titre doit contenir au moins 5 caracteres ! Recommencez...";
    public static final String REQ_TITRE = "REQUETE : Le titre contient l'expression";
    public static final String MSG_AUTEUR = "*** RECHERCHE PAR AUTEUR ***";
    public static final String MSG_SOL_AUTEUR = "Entrez le nom de l'auteur (<ENTREE> pour terminer) : ";
    public static final String ERR_AUTEUR = "Erreur, le nom de l'auteur doit contenir au moins 3 caracteres ! Recommencez...";
    public static final String REQ_AUTEUR = "REQUETE : Le nom de l'auteur est ";
    public static final String MSG_PER = "*** RECHERCHE PAR PERIODE ***";
    public static final String MSG_SOL_PER_DEB = "Entrez l'annee du debut de la periode (0 pour terminer) : ";
    public static final String MSG_SOL_PER_FIN = "Entrez l'annee de la fin de la periode (0 pour terminer) : ";
    public static final String ERR_PER = "Erreur, l'annee doit etre un entier entre 1900 et 2019 inclusivement! Recommencez...";
    public static final String REQ_PER = "REQUETE : L'annee est entre ";
    public static final String REQ_PER_FIX = "REQUETE : L'annee est ";

    public static String afficherMenu() {
        //----------
        //VARIABLES
        //----------
        String choix;

        System.out.println("-----------------");
        System.out.println(MENU);
        System.out.println(CHOIX + "\n");
        System.out.print(MSG_SOL_CHOIX);
        choix = Clavier.lireString();
        while (!(choix.equals("1")) && !(choix.equals("2")) && !(choix.equals("3")) && !(choix.equals("4")) && !(choix.equals("5"))) {
            System.out.println(ERR_CHOIX);
            Clavier.viderTampon();
            choix = Clavier.lireString();
        }
        return choix;
    }
    

    public static void main() {
        //----------
        //VARIABLES
        //----------
        String choix;
        System.out.println(MSG_PRES);
        System.out.println(CHOIX);
        String biblio = UtilitaireTP2.lireBibliotheque();
        System.out.print(biblio +"\n\n\n");
        choix = afficherMenu();
        System.out.print(choix);
    }
}
