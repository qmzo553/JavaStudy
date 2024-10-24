import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        ans += n / 1000;
        ans += (n % 1000) / 100;
        ans += (n % 100) / 10;
        ans += n % 10;

        System.out.println(ans);
    }
}
