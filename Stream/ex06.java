import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ex06 {
    public static void main(String[] args) {
        // collecting ex
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");

        List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        // List<String> resultList2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        resultList.stream().forEach(System.out::println);
    }
}
