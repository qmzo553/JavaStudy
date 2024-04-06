import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class ex08 {
    public static void main(String[] args) {
        // Collection 과 array 의 stream
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        streamOfCollection.forEach(System.out::println);

        // 배열을 생성하지 않고 바로 stream 으로 주입
        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        // 배열을 생성하여 전체를 stream으로 생성할 수 있고, 부분적으로 stream 생성 가능.
        String[] arr = new String[]{"a", "b", "c", "d", "e"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        streamOfArrayFull.forEach(System.out::print);
        streamOfArrayPart.forEach(System.out::print);
    }
}
