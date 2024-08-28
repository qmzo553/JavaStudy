import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        long[][] dp = new long[101][101];

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= 100; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }

                dp[i][j] %= 1_000_000_000;
            }
        }

        for(int i = 0; i <= 9; i++) {
            ans += dp[n][i];
        }

        System.out.println(ans % 1_000_000_000L);
    }
}
