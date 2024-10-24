import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 1; i <= n; i++) {
            ans += i;
        }

        System.out.println(ans);
    }
}
