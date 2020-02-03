import java.util.function.Function;

public class XCube implements Function<Double,Double> {
    @Override
    public Double apply(Double x) {
        return x+3;
    }
}

