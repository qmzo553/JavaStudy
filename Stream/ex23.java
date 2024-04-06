import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex23 {
    
    public static void main(String[] args) {
        // Predicates -> 일반화 된 값을 받아 불리언 값을 반환한다.
        List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

        List<String> namesWithA = names.stream()
                                    .filter(name -> name.startsWith("A"))
                                    .collect(Collectors.toList());

        namesWithA.forEach(System.out::println);
    }
}
