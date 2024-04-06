import java.util.List;
import java.util.stream.Stream;

public class ex07 {
    public static void main(String[] args) {
        // empty stream ex
        // 빈 스트림을 생성할 때는 empty() 메서드를 사용해야 한다.
        // 하지만 빈 스트림을 반환하는 경우에는 null을 반환하지 않도록 empty() 메서드를 만들어 사용하는 것이 일반적이다.
        Stream<String> streamEmpty = Stream.empty();
    }

    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}
