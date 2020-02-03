

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;

public class Principal {

    private static Object Quatre;

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add( 3 );
        a.add( 5 );
        a.add( 7 );

        a.forEach(new Affiche());
    }
}