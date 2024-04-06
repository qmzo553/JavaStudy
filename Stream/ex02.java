import java.util.ArrayList;
import java.util.stream.Stream;

public class ex02 {
    
    public static void main(String[] args) {
        // filter ex
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        Stream<String> stream = list.stream().filter(element -> element.contains("d"));
        stream.forEach(System.out::println);
    }
}
