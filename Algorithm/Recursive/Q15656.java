import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15656 {

    static int n;
    static int m;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        bfs(0);

        System.out.println(sb);
    }

    public static void bfs(int depth) {
        if(depth == m) {
            for(int num : ans) {
                sb.append(num).append(' ');
            }

            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++) {
            ans[depth] = arr[i];
            bfs(depth + 1);
        }
    }
}
