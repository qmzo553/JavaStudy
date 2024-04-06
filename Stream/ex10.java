import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ex10 {
    public static void main(String[] args) throws IOException {
        // Primitives ex
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        // 3가지 요소를 가지고 있는 stream 생성
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

        Path path = Paths.get("./file.txt");
        try (Stream<String> streamOfStrings = Files.lines(path);
                Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);) {

            streamOfStrings.forEach(System.out::println);
            System.out.println(); 
            streamWithCharset.forEach(System.out::println);
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
        }

        intStream.forEach(System.out::println);
        System.out.println();
        longStream.forEach(System.out::println);
        System.out.println();
        doubleStream.forEach(System.out::println);
        System.out.println();
        streamOfChars.forEach(System.out::println);
        System.out.println();
        streamOfString.forEach(System.out::println);
        System.out.println();
    }
}
