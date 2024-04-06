import java.util.Collections;

public class ex26 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        String str = "happy";
        char[] chars = str.toCharArray();

        Collections.reverse(chars);

        System.out.println(chars);
    }
}
