public class Fraction
    extends Object
        implements Eq <Fraction>{
    /**
     * Champ contenant le numerateur d'une <code>Fraction</code>.
     */
    private int _numerateur;
    /**
     * Champ contenant le denominateur d'une <code>Fraction</code>.
     */
    private int _denominateur;

    /**
     * Le code contenu les accolades suivantes est execute avant l'appel
     * des constructeurs.
     */
    {
        // @test : qu'arrive t'il si la declaration de la variable place une
        // valeur differente que la ligne suivante ?  en d'autre terme,
        // lequel est execute en premier ?
        // faites des tests.
        _denominateur = 1;
    }

    /**
     * Une <code>Fraction</code> representant la valeur 0 / 1.
     */
    public static final Fraction ZERO;
    /**
     * Une <code>Fraction</code> representant la valeur 1 / 1.
     */
    public static final Fraction UN;

    /**
     * Calcule le plus grand commun diviseur entre deux valeurs entiere.
     * @param a La premiere valeur.
     * @param b La deuxieme valeur.
     * @return le pgcd entre les deux valeurs.
     */
    private static int pgcd( int a, int b ){
        int temp = 0;

        a = Math.abs( a );
        b = Math.abs( b );

        while( b != 0 ) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    @Override
    public boolean estEgal(Fraction f) {
        return _numerateur * f._denominateur
                ==
                _denominateur * f._numerateur;
    }



    /**
     * Normalise une <code>Fraction</code> afin de faciliter les comparaisons.
     * Par exemple, les fractions suivantes sont toutes la meme :
     * 1 / 1, -1 / -1, 2 / 2, 5 / 5, ...
     * Si la fraction est negative, alors le <code>_numerateur</code> contiendra
     * le signe.
     */
    private void normaliser() {
        int diviseurCommun = pgcd( _numerateur, _denominateur );
        diviseurCommun *= Integer.signum( _denominateur );

        _numerateur /= diviseurCommun;
        _denominateur /= diviseurCommun;
    }

    /**
     * Le code contenu dans les accolades precede du mot clef 'static'
     * est execute 1 fois.
     */
    static {
        ZERO = new Fraction( 0 );
        UN = new Fraction( 1 );
    }

    /**
     * Construit une nouvelle <code>Fraction</code> a l'aide de deux valeurs.
     * @param numerateur   Le numerateur de la <code>Fraction</code>.
     * @param denominateur Le denominateur de la <code> Fraction</code>.
     * @throws DenominateurZero Est leve si le denominateur est a 0.
     */
    public Fraction( int numerateur, int denominateur ) throws DenominateurZero {
        _numerateur = numerateur;
        setDenominateur( denominateur );
    }

    /**
     * Construit une nouvelle <code>Fraction</code> representant un nombre entier.
     * @param valeur La valeur entiere a representer.
     */
    public Fraction( int valeur ) {
        _numerateur = valeur;
    }

    /**
     * Compare une <code>Fraction</code> a un autre objet.
     * @param obj L'<code>Object</code> compare a la <code>Fraction</code>.
     * @return Retourne <code>false</code> si l'argument est <code>null</code>
     *         ou si ce n'est pas une <code>Fraction</code>.  Sinon retourne
     *         <code>true</code> si les <code>Fraction</code> represente la<
     *         meme valeur, <code>false</code> sinon.
     */
    // En Java, les methodes ont des qualificatif, comme 'public', 'static', ...
    // Les annotations sont un autre type de qualificatif.  Le caractere '@'
    // represente un  qualificatif de type Annotation.  Il est place avant le
    // nom de l'annotation.
    // Ici, nous utilisons l'annotation Override, qui indique que la signature
    // de la methode existe deja dans la super classes Object et que nous
    // voulons la specialiser pour la classe Fraction.
    // Ainsi, le compilateur va verifier que la signature existe, sinon une
    // erreur sera retournee.
    // La methode 'equals' de la classe 'Object' compare deux Objects en
    // comparant les references, si les references sont egales, alors
    // la methode retourne true, sinon elle retourne 'false'.
    @Override
    public boolean equals( Object obj ) {
        boolean resultat = false;

        // l'operateur 'instanceof' permet de verifie si
        // une variable est une instance d'une classe.
        // Tres important de verifier, puisque nous recevons un argument
        // de type Object.
        if( null != obj && obj instanceof Fraction ) {
            // Faire un 'cast' de l'objet en Fraction, afin de pouvoir
            // acceder au champ de la Fraction et pouvoir faire la
            // comparaison.
            Fraction temp = (Fraction) obj;
            resultat= _numerateur == temp._numerateur
                    &&
                    _denominateur == temp._denominateur;
        }

        return resultat;
    }

    /**
     * Consulte le denominateur.
     * @return Le denominateur de la <code>Fraction</code>.
     */
    public int getDenominateur() {
        return _denominateur;
    }

    /**
     * Consulte le numerateur.
     * @return Le numerateur de la <code>Fraction</code>.
     */
    public int getNumerateur() {
        return _numerateur;
    }

    /**
     * Permet de modifier le denominateur d'une <code>Fraction</code>.
     * @param denominateur Le nouveau denominateur.
     * @throws DenominateurZero Est leve si le denominateur est a 0.
     */
    public void setDenominateur( int denominateur ) throws DenominateurZero {
        if( 0 == denominateur ) {
            throw new DenominateurZero();
        }

        _denominateur = denominateur;
        normaliser();
    }

    /**
     * Permet de modifier le numerateur d'une <code>Fraction</code>.
     * @param numerateur Le nouveau numerateur.
     */
    public void setNumerateur( int numerateur ){
        _numerateur = numerateur;
        normaliser();
    }

    /**
     * permet d'acceder au equals de la super classe Object.
     * @param obj La valeur a comparer.
     * @return Le resultat genere par le equals de la super classe Object.
     */
    public boolean superEquals( Object obj ) {
        return super.equals( obj );
    }

    /**
     * permet d'acceder au toString de la super classe Object.
     * @return La representation genere par le toString de la super classe
     *         Object.
     */
    public String superToString() {
        return super.toString();
    }

    /**
     * @return Une representation affichable d'une <code>Fraction</code>.
     */
    // La methode 'toString' de la classe Object retourne une chaine de
    // caractere contenant le nom de la classe a qui appartient l'instance
    // et l'adresse (reference) de l'instance.
    @Override
    public String toString() {
        return _numerateur + "/" + _denominateur;
    }


    public int compareTo( Fraction arg0 ) {
        return
                ( this._numerateur * arg0._denominateur )
                        -
                        ( this._denominateur * arg0._numerateur );
    }
}