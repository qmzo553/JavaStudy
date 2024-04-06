import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;

public class ex16 {
    public static void main(String[] args) {
        // collect() ex
        List<Product> productList = Arrays.asList(
            new Product(23, "potatoes"),
            new Product(14, "orange"),
            new Product(13, "lemon"),
            new Product(23, "bread"),
            new Product(13, "sugar")
        );

        // Collection 으로 변환
        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
        collectorCollection.stream().forEach(System.out::println);

        // 하나의 문자열로 합성
        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(listToString);

        // 스트림의 모든 숫자 요소의 평균 값 처리
        double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));
        System.out.println(averagePrice);

        // 스트림의 모든 숫자 요소의 합
        int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));
        System.out.println(summingPrice);

        // 스트림 요소를 지정된 함수에 따라 그룹화하는 방법
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
        System.out.println(collectorMapOfLists);

        // 병렬 스트림
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        boolean bigPrice = streamOfCollection.map(product -> product.getPrice() * 12).anyMatch(price -> price > 200);
        System.out.println(isParallel);
        System.out.println(bigPrice);

        // 스트림의 소스가 Collection 또는 array가 아닌 경우, parallel() 메서드 사용.
        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        boolean isParallel1 = intStreamParallel.isParallel();
        System.out.println(isParallel1);

        // 병렬 스트림에서 순차 스트림으로 변환
        IntStream intStreamSequential = intStreamParallel.sequential();
        boolean isParallel2 = intStreamSequential.isParallel();
        System.out.println(isParallel2);
    }
}

class Product {

    int price;
    String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
