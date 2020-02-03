import java.util.function.Consumer;

public class Affiche implements Consumer <Integer> {
    @Override
    public void accept( Integer x) {
        System.out.println( "x = " + x);
    }
}
