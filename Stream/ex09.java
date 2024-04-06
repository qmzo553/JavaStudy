import java.util.stream.Stream;

public class ex09 {
    public static void main(String[] args) {
        // builder() ex
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        streamBuilder.forEach(System.out::println);

        // generate() ex
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);

        // iterate() ex
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        streamIterated.forEach(System.out::println);
    }
}
