import java.util.Arrays;
import java.util.List;

public class ex05 {
    public static void main(String[] args) {
        // reduction ex
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);

        integers.stream().forEach(System.out::println);
        System.out.println(reduced);
    }
}
