import java.io.*;

/**
 * INF1120 H19 : Module utilitaire a utiliser pour le TP2.
 * Cette classe contient une methode de classe pour lire le contenu du 
 * fichier FIC_BIBLIO qui doit se trouver a la racine du projet (ou dans
 * le meme repertoire que l'application).
 * 
 * @author melanie lord
 * @version mars 2019
 */
public class UtilitaireTP2 {

   public final static String FIC_BIBLIO = "biblio.txt";
   public final static String MSG_ERR = "\n\nERREUR INNATTENDUE !\nCette erreur "
           + "ne devrait pas se produire. \nVerifiez que votre fichier est bien"
           + "a la racine de votre projet\nou demandez de l'aide a votre "
           + "enseignante.";

   /**
    * Cette methode lit le contenu du fichier FIC_BIBLIO et le retourne 
    * sous la forme d'une chaine de caracteres.
    * 
    * Lors de la lecture, les lignes commencant avec le caractere # ou les 
    * lignes vides (ne contenant que des carateres blancs) sont ignorees.
    * 
    * @return le contenu de FIC_BIBLIO sous forme d'une chaine de caracteres.
    */
   public static String lireBibliotheque () {
      BufferedReader in;
      String biblio = "";
      String ligne;
      
      try {
         in = new BufferedReader(new FileReader(FIC_BIBLIO));
         
         //lire les lignes non commentees (commencant par #) et non blanches.
         while (in.ready()) {
            ligne = in.readLine().trim();
            
            if (!ligne.isEmpty() && !ligne.startsWith("#")) {
               biblio = biblio + ligne + "\n";
            }
            
         }
         
      } catch (IOException e) {
         System.err.println(MSG_ERR);
      }
   
      return biblio.trim();
   }
   
}
