import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2806 {

    private static int result, n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            dfs(0);

            sb.append(result).append("\n");
            result = 0;
        }

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == n) {
            result++;
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[depth] = i;

            if(isVaild(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isVaild(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            }

            if(Math.abs(i - col) == Math.abs(arr[i] - arr[col])) {
                return false;
            }
        }

        return true;
    }
}
