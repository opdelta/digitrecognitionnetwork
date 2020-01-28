public interface Ord< T > extends Eq < T >{
    boolean estPlusPetit( T v2);
    default boolean estPlusGrand( T v2) {
        return !estPlusPetitEq(v2);
    }
    default boolean estPlusPetitEq( T v2) {
        return estPlusPetit(v2) && !estEgal(v2);
    }
    default boolean estPlusGrandEq( T v2) {
        return ! estPlusPetit(v2);
    }

}
