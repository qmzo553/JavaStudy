import java.util.Arrays;
import java.util.List;

public class ex14 {

    private static long counter;
    private static void wasCalled() {counter++;}
    public static void main(String[] args) {
        // Order of Execution ex
        // stream의 크기를 줄이는 중간 작업은 각 요소에 적용되는 작업보다 앞에 배치해야 한다.
        // skip(), filter(), distinct() 와 같은 메서드들은 스트림 파이프라인 맨 위에 유지해야 한다.
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        long size = list.stream().map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).skip(2).count();

        System.out.println(counter);
        System.out.println(size);

        long size1 = list.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).count();

        System.out.println(counter);
        System.out.println(size1);
    }
}
