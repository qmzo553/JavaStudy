import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {

    public static int n, m;
    public static int count = 0;
    public static int[][] map;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        System.out.println(dfs(1));
    }

    public static int dfs(int i) {
        visited[i] = true;

        for(int j = 1; j <= n; j++) {
            if(map[i][j] == 1 && visited[j] == false) {
                count++;
                dfs(j);
            }
        }

        return count;
    }
}
