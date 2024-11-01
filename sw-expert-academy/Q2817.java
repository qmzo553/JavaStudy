import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2817 {

    private static int n, k, count;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            count = 0;
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int sum) {
        if(sum > k) {
            return;
        }

        if(depth == n) {
            if(sum == k) {
                count++;
            }

            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
