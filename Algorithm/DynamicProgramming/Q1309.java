import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[][] dp = new int[n + 1][3];

        Arrays.fill(dp[1], 1);

        for(int i = 2; i <= n; i++) {

            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][2] + dp[i - 1][0];
            dp[i][2] = dp[i - 1][1] + dp[i - 1][0];
            dp[i][0] %= 9901;
            dp[i][1] %= 9901;
            dp[i][2] %= 9901;
        }

        for(int i = 0; i < 3; i++) {
            ans += dp[n][i];
        }

        System.out.println(ans % 9901);
    }
}
