import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ex13 {
    
    private static long counter;
    private static void wasCalled() {counter++;}

    public static void main(String[] args) {
        // Lazy Invocation ex
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
        System.out.println(counter);
        stream.forEach(System.out::println);

        // list의 두 번째 요소에서 첫 번째로 값을 찾게 되어서 더 이상 filter와 map이 실행되지 않고 종료했다.
        Optional<String> stream1 = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
        System.out.println(stream1);
    }
}
