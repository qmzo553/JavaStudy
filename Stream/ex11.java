import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ex11 {
    public static void main(String[] args) {
        // referencing a stream
        // 중간 연산만 호출되는 한 스트림을 인스턴스화 하고, 접근 가능한 참조를 가질 수 있다.
        // 최종 연산을 실행하면 스트림에 접근할 수 없다.
        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();

        System.out.println(anyElement);

        // Optional<String> firstElement = stream.findFirst();

        // System.out.println(firstElement); // IllegalStateException() 발생!!!

        List<String> elements = Stream.of("a", "b", "c")
                                    .filter(element -> element.contains("b"))
                                    .collect(Collectors.toList());

        Optional<String> anyElement1 = elements.stream().findAny();
        Optional<String> firstElement1 = elements.stream().findFirst();

        System.out.println(anyElement1);
        System.out.println(firstElement1);
    }
}
