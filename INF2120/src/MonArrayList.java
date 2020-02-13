import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class MonArrayList<E> extends ArrayList<E> {
    // "this" est un MonArrayList qui est aussi un ArrayList.

    public  <R> MonArrayList<R>
    map(Function<E, R> f) {
        MonArrayList<R> r = new MonArrayList<>();

        for (E x : this) {
            r.add(f.apply(x));
        }
        return r;
    }

    public MonArrayList<E> filter(Predicate<E> t) {
        MonArrayList< E > r = new MonArrayList<>();

        for (E x : this) {
            if (t.test(x)) {
                r.add(x);
            }
        }
        return r;
    }
}
