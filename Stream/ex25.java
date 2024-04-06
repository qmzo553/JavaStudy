import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;

public class ex25 {
    
    public static void main(String[] args) {
        // Collectors ex
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        List<String> result1 = givenList.stream().collect(toList());
        result1.forEach(System.out::println);
        System.out.println();

        List<String> result2 = givenList.stream().collect(toUnmodifiableList());
        result2.forEach(System.out::println);
        System.out.println();

        Set<String> result3 = givenList.stream().collect(toUnmodifiableSet());
        result3.forEach(System.out::println);
        System.out.println();

        List<String> result4 = givenList.stream().collect(toCollection(LinkedList::new));
        result4.forEach(System.out::println);
        System.out.println();

        Map<String, Integer> result5 = givenList.stream().collect(toMap(Function.identity(), String::length));
        for(Entry<String, Integer> entry : result5.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        Map<String, Integer> result6 = givenList.stream().collect(toUnmodifiableMap(Function.identity(), String::length));
        for(Entry<String, Integer> entry : result6.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        String result7 = givenList.stream().collect(joining());
        System.out.println(result7);
        System.out.println();

        String result8 = givenList.stream().collect(joining(" "));
        System.out.println(result8);
        System.out.println();

        String result9 = givenList.stream().collect(joining(" ", "PRE-", "-POST"));
        System.out.println(result9);
        System.out.println();

        Long result10 = givenList.stream().collect(counting());
        System.out.println(result10);
        System.out.println();

        DoubleSummaryStatistics result11 = givenList.stream().collect(summarizingDouble(String::length));
        System.out.println(result11);
        System.out.println();

        Double result12 = givenList.stream().collect(averagingDouble(String::length));
        System.out.println(result12);
        System.out.println();

        Double result13 = givenList.stream().collect(summingDouble(String::length));
        System.out.println(result13);
        System.out.println();

        Optional<String> result14 = givenList.stream().collect(maxBy(Comparator.naturalOrder()));
        System.out.println(result14);
        System.out.println();

        Map<Integer, Set<String>> result15 = givenList.stream().collect(groupingBy(String::length, toSet()));
        for (Entry<Integer, Set<String>> entry : result15.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        Map<Boolean, List<String>> result16 = givenList.stream().collect(partitioningBy(s -> s.length() > 2));
        for(Entry<Boolean, List<String>> entry : result16.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
