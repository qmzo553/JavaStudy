import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ex12 {

    public static void main(String[] args) {
        // Stream Pipeline ex
        // 스트림을 이용한 데이터 소스의 요소에 대해 일련의 작업을 수행하고 결과를 집계하려면 소스, 중간 작업, 최종 작업 3가지가 필요하다.
        Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
        onceModifiedStream.forEach(System.out::println);

        Stream<String> stream = Stream.of("abcd", "efgh", "jklm");
        Stream<String> twiceModifiedStream = stream.skip(1)
                                                .map(element -> element.substring(0, 3));
        twiceModifiedStream.forEach(System.out::println);

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
        System.out.println(size);
    }
}
