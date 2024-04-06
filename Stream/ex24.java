import java.util.Arrays;
import java.util.List;

public class ex24 {
    
    public static void main(String[] args) {
        // Operators -> 동일한 값 유형을 받아들이고 반환하는 함수이다.
        List<String> names = Arrays.asList("bob", "josh", "megan");
        names.replaceAll(name -> name.toUpperCase());
        // names.replaceAll(String::toUpperCase);

        names.forEach(System.out::println);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);

        int sum = values.stream()
                        .reduce(0, (i1, i2) -> i1 + i2);

        System.out.println(sum);

        Thread thread = new Thread(() -> System.out.println("Hello From Another Thread"));
        thread.start();
    }
}
