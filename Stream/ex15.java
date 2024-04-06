import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ex15 {
    public static void main(String[] args) {
        // Stream Reduction
        // 최종 작업 메서드로 count(), max(), min(), sum() 등이 있다.
        // 사용자가 정의 해야 할 경우 reduce() 와 collect() 메서드 두가지를 사용한다.
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);

        int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);

        int reducedParams = Stream.of(1, 2, 3)
                                .reduce(10, (a, b) -> a + b, (a, b) -> {
                                    System.out.println("combiner was called");
                                    return a + b;
                                });

        System.out.println(reducedTwoParams);
        System.out.println(reducedParams);
    }
}
