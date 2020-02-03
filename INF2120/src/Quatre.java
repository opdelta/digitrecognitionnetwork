import java.util.function.Supplier;

public class Quatre implements Supplier<Double> {
    @Override
    public Double get() {
        return Math.random();
    }
}
