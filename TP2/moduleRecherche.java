/*
 *Petite application qui permet d'exécuter diverses requêtes pour rechercher des
 *livres dans une bibliothèque (liste de livres) donnée. Cette application permettra plus particulièrement de faire des
 *recherches par catégorie(s), par expression dans le titre, par auteur, et par période de publication.
 *
 * @author Ziad Lteif (LTEZ18059802)
 * @version Mars 2019
 */
public class moduleRecherche {
    //--------------------
    //CONSTANTES
    //--------------------

    public static final String MSG_PRES = "Cette application permet d'executer diverses requetes pour rechercher des livres\ndans une bibliotheque donnee. Elle permet plus particulierement de faire des\nrecherches par categorie(s), par expression dans le titre, par auteur, et par\nperiode de publication.\n";
    public static final String ERR_CHOIX = "Erreur, choix invalide! Recommencez...";
    public static final String MENU = "MENU DE RECHERCHE";
    public static final String CHOIX = "1. Recherche par categorie(s) \n2. Recherche par titre\n3. Recherche par auteur\n4. Recherche par periode\n5. Quitter\n";
    public static final String MSG_SOL_CHOIX = "Entrez votre choix : ";
    public static final String MSG_FIN = "AUREVOIR !";
    public static final String MSG_CAT = "*** RECHERCHE PAR CATEGORIE(S) ***\n";
    public static final String MSG_SOL_CAT = "Recherche par (C)onjonction ou (D)isjonction : ";
    public static final String MSG_ERR_CAT = "Erreur, entrez C ou D ! Recommencez...";
    public static final String LISTE_CAT = "\n LISTE DES CATEGORIES : \n   1. Science fiction \n   2. Romance \n   3. Thriller \n   4. Policier \n   5. Humeur \n   6. Drame \n";
    public static final String MSG_SOL_NUM_CAT = "Entrez un numero de categorie (0 pour terminer) : ";
    public static final String MSG_ERR_NUM_CAT = "Erreur, numero de categorie invalide! Recommencez...";
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
    public static String BIBLIO = UtilitaireTP2.lireBibliotheque();

    /*
     * Methode qui affiche le menu principal et qui effectue une boucle de validation
     * et retourne le choix en string.
     * 
     * @return choix en string de l'utilisateur.
     */
    public static String afficherMenu() {
        //----------
        //VARIABLES
        //----------
        String choix;

        System.out.println("-----------------");
        System.out.println(MENU);
        System.out.println("-----------------");
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

    public static void rechercheCategorie() {
        //----------
        //VARIABLES
        //----------
        char choixRecherche;
        char choixNumeroRecherche;
        String choixCategories = "";

        System.out.println(MSG_CAT);
        System.out.print(MSG_SOL_CAT);
        choixRecherche = Clavier.lireChar();
        choixRecherche = Character.toUpperCase(choixRecherche);
        while (choixRecherche != 'C' && choixRecherche != 'D') {
            Clavier.viderTampon();
            System.out.println(MSG_ERR_CAT);
            choixRecherche = Clavier.lireChar();
            choixRecherche = Character.toUpperCase(choixRecherche);
        }
        System.out.println(LISTE_CAT);
        Clavier.viderTampon();
        System.out.print(MSG_SOL_NUM_CAT);
        choixNumeroRecherche = Clavier.lireChar();
        while (choixNumeroRecherche != '0') {
            Clavier.viderTampon();
            System.out.print(MSG_SOL_NUM_CAT);
            choixNumeroRecherche = Clavier.lireChar();
            while (choixNumeroRecherche != '0'&& choixNumeroRecherche != '1' && choixNumeroRecherche != '2' && choixNumeroRecherche != '3' && choixNumeroRecherche != '4' && choixNumeroRecherche != '5' && choixNumeroRecherche != '6') {
                Clavier.viderTampon();
                System.out.println(MSG_ERR_NUM_CAT);
                System.out.print(MSG_SOL_NUM_CAT);
                choixNumeroRecherche = Clavier.lireChar();
            }
            if (choixRecherche == 'C') {
                choixCategories = choixCategories;
                if (choixNumeroRecherche == '1') {
                    choixCategories = choixCategories + "Science Fiction ";
                    if (choixCategories.contains("Science Fiction")) {
                        choixCategories = choixCategories;
                    }

                } else if (choixNumeroRecherche == '2') {
                    if (choixCategories.contains("Romance ")) {
                        choixCategories = choixCategories;
                    } else {
                        choixCategories = choixCategories + "Romance ";
                    }
                } else if (choixNumeroRecherche == '3') {
                    if (choixCategories.contains("Thriller ")) {
                        choixCategories = choixCategories;
                    } else {
                        choixCategories = choixCategories + "Thriller ";
                    }
                } else if (choixNumeroRecherche == '4') {
                    if (choixCategories.contains("Policier ")) {
                        choixCategories = choixCategories;
                    } else {
                        choixCategories = choixCategories + "Policier ";
                    }
                } else if (choixNumeroRecherche == '5') {
                    if (choixCategories.contains("Humeur ")) {
                        choixCategories = choixCategories;
                    }else {
                        choixCategories = choixCategories + "Humeur ";
                    }
                } else if (choixNumeroRecherche == '6') {
                    if (choixCategories.contains("Drame ")) {
                        choixCategories = choixCategories;
                    } else {
                        choixCategories = choixCategories + "Drame ";
                    }
                }
                
            }
        }
        System.out.print(REQ);
        System.out.println(choixCategories);

    }

    public static void rechercheTitre() {
        String entreeTitre = null;
        boolean contientTitre = false;
        int indexEntreeTitre;
        int indexFinEntreeTitre;
        int lengthBiblio;
        System.out.println(MSG_TITRE + "\n");
        System.out.print(MSG_SOL_TITRE);
        entreeTitre = Clavier.lireString();
        while (entreeTitre.length() < 5) {
            System.out.println(ERR_TITRE);
            System.out.print(MSG_SOL_TITRE);
            entreeTitre = Clavier.lireString();
        }
        contientTitre = BIBLIO.contains(entreeTitre);
        if (contientTitre == false) {
            System.out.println(MSG_RECH_NUL);
            System.out.print(MSG_SOL_ENTREE);
            Clavier.lireFinLigne();
        } else {
            indexEntreeTitre = BIBLIO.lastIndexOf(entreeTitre);
            indexFinEntreeTitre = BIBLIO.indexOf(entreeTitre);
            System.out.print(BIBLIO.substring(indexFinEntreeTitre, indexEntreeTitre) + "\n");
        }
    }

    public static void rechercheAuteur() {
        String entreeAuteur = null;
        boolean contientAuteur = false;
        int indexEntreeAuteur;
        int indexFinEntreeAuteur;
        System.out.println(MSG_AUTEUR + "\n");
        System.out.print(MSG_SOL_AUTEUR);
        entreeAuteur = Clavier.lireString();
        while (entreeAuteur.length() < 3) {
            System.out.println(ERR_AUTEUR);
            System.out.print(MSG_SOL_AUTEUR);
            entreeAuteur = Clavier.lireString();
        }
        contientAuteur = BIBLIO.contains(entreeAuteur);
        if (contientAuteur == false) {
            System.out.println(MSG_RECH_NUL);
            System.out.print(MSG_SOL_ENTREE);
            Clavier.lireFinLigne();
        } else {
            indexEntreeAuteur = BIBLIO.indexOf(entreeAuteur);
            indexFinEntreeAuteur = BIBLIO.lastIndexOf(entreeAuteur);
            System.out.print(BIBLIO.substring(indexEntreeAuteur, indexFinEntreeAuteur));
        }
    }

    public static void recherchePeriode() {
    }

    public static void main() {
        //----------
        //VARIABLES
        //----------
        String choix;
        System.out.println(MSG_PRES);
        System.out.println(CHOIX);
        choix = afficherMenu();
        while (!(choix.equals("5"))) {
            if (choix.equals("1")) {
                rechercheCategorie();
                Clavier.viderTampon();
            } else if (choix.equals("2")) {
                rechercheTitre();
                Clavier.viderTampon();
            } else if (choix.equals("3")) {
                rechercheAuteur();
                Clavier.viderTampon();
            } else if (choix.equals("4")) {
                recherchePeriode();
                Clavier.viderTampon();
            }
            choix = afficherMenu();
        }
        System.out.println(MSG_FIN);
    }
}

