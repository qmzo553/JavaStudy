import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ex18 {
    
    public static void main(String[] args) {
        // functional interface
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);

        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        System.out.println(quoteIntToString.apply(5));
    }
}
