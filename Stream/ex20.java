import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ex20 {

    public static void main(String[] args) {
        // parameter 가 두 개 일때
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

        for(Entry<String, Integer> entry : salaries.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}