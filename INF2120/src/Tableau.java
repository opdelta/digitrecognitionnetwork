import java.util.function.Consumer;

public class Tableau {
    protected int [] t;

    public Tableau() {
        t = new int[5];
    }

    public void set(int pos, int val) {
        t[pos] = val;
    }
    public int somme() {
        int r = 0;

        for( int i = 0; i < 5; ++i) {
            r += t[i];
        }
        return r;
    }
    public void forEachV(Consumer<Integer> methode) {
        for( Integer x : t) {
            methode.accept(x);
        }
    }
}
