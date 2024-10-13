import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0][0] = true;

        bfs(0, 0);

        System.out.println(map[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < 0 ||
                        ny < 0 ||
                        nx >= n ||
                        ny >= m ||
                        visited[nx][ny] ||
                        map[nx][ny] == 0) continue;

                q.add(new int[]{nx, ny});
                map[nx][ny] = map[nowX][nowY] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}
