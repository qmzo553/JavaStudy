import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ex01 {
    public static void main(String[] args) {
        String[] arr = new String[] { "a", "b", "c" };
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // Stream 생성하는 방법 2가지.
        Stream<String> stream1 = Arrays.stream(arr);
        stream1 = Stream.of("a", "b", "c");

        Stream<String> stream2 = list.stream();

        // parallelStream() 메서드로 스트림의 요소를 병렬 모드로 처리하여 다중 스레딩을 간단하게 구현.
        list.parallelStream().forEach(element -> doWork(element));
        // list.parallelStream().forEach(ex01::doWork); 람다식 표현 변경. -> 컴파일러가 자동으로 매개변수를
        // 처리한다.

        long count = list.stream().distinct().count();
        System.out.println("count : " + count);

        // stream은 for, for-each, while을 대체할 수 있다.
        boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
        // for (String string : list) {
        //     if (string.contains("a")) {
        //         boolean isExist2 = true;
        //     }
        // }
        System.out.println("isExist : " + isExist);
    }

    public static void doWork(String element) {
        System.out.println(element);
    }
}