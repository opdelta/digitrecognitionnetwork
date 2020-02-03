import java.util.function.Function;

public class XDeux implements Function<Double, Double> {
    @Override
    public Double apply(Double x) {
        return x * x;
    }

}
