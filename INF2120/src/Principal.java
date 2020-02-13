

import java.lang.reflect.Array;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Principal {


    public static void main(String[] args) {
        MonArrayList<Integer> ss= new MonArrayList<>();
        ss.add(3);
        ss.add(5);
        ss.add(7);
        MonArrayList<Integer> r2 =
                ss.filter(x -> x < 5);
        System.out.println("r =" + r2);

    }
}