import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2050 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            int n = str.charAt(i) - 64;

            sb.append(n).append(" ");
        }

        System.out.println(sb);
    }
}
