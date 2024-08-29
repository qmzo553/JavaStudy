import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {

    public static int n, result;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        result = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int depth, int pay) {
        if(depth >= n) {
            result = Math.max(result, pay);
            return;
        }

        if(depth + arr[depth][0] <= n) {
            dfs(depth + arr[depth][0], pay + arr[depth][1]);
        } else {
            dfs(depth + arr[depth][0], pay);
        }

        dfs(depth + 1, pay);
    }
}
