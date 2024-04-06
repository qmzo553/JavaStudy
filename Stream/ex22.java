import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ex22 {
    
    public static void main(String[] args) {
        // Consumers -> 일반화된 인수를 받고 아무 것도 반환하지 않는다.
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
}
