import java.util.function.Supplier;
import java.util.stream.Stream;

public class ex21 {
    
    public static void main(String[] args) {
        // Suppliers -> 인수를 전혀 사용하지 않는 또 다른 Function 특수화 이다. 값을 게으르게 생성하는데 사용
        Supplier<Double> lazyValue = () -> {
            // Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
            return 9d;
        };

        Double valueSquared = squareLazy(lazyValue);

        System.out.println(valueSquared);

        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });

        fibonacci.forEach(System.out::println);
    }

    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }
}
