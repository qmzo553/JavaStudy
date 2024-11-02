import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2814 {

    private static int n, m, max;
    private static int[][] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n + 1][n + 1];
            visited = new boolean[n + 1];
            max = Integer.MIN_VALUE;

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                map[y][x] = 1;
            }

            for(int i = 1; i <= n; i++) {
                dfs(1, i);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int v) {
        visited[v] = true;

        max = Math.max(max, depth);

        for(int i = 1; i <= n; i++) {
            if(map[v][i] == 1 && !visited[i]) {
                dfs(depth + 1, i);
            }
        }

        visited[v] = false;
    }
}
