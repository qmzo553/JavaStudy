import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
    int x, y;

    public tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q7576 {
    public static int n, m;
    public static int[][] map;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static Queue<tomato> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    q.add(new tomato(i, j));
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!q.isEmpty()) {
            tomato nt = q.poll();

            int x = nt.x;
            int y = nt.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                   q.add(new tomato(nx, ny));

                   map[nx][ny] = map[x][y] + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    return -1;
                }

                result = Math.max(result, map[i][j]);
            }
        }

        if(result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}
