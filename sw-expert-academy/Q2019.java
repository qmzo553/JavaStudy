import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int ans = 1;
        sb.append(ans).append(" ");

        while(n-- > 0) {
            ans *= 2;
            sb.append(ans).append(" ");
        }

        System.out.println(sb);
    }
}
