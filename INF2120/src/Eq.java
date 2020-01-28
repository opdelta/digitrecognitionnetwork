/**
 *
 * Role de l'interface
 * @param <T>
 */
public interface Eq  < T >{
    int y = 0;
    /**
     *
     * Classe d'equivalence... (service(s) offert(s)).
     * @param v2
     * @return
     */
    boolean estEgal( T v2 );
    default boolean nEstPasEgal(T v2){
        return !estEgal( v2);
    }

}
