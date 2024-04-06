import java.util.ArrayList;
import java.util.List;

public class ex04 {
    public static void main(String[] args) {
        // matching ex
        List<String> list = new ArrayList<>();
        list.add("Change");
       
        boolean isValid = list.stream().anyMatch(element -> element.contains("h"));
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h"));
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h"));

        System.out.println(isValid + " " + isValidOne + " " + isValidTwo);

        // Stream.empty().allMatch(Objects::nonNull);
        // Stream.empty().anyMatch(Objects::nonNUll);
    }
}
