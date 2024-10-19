import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
    public static int n, count, ccount;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static char[][] map, cmap;
    public static boolean[][] visited, cvisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        cmap = new char[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'G') {
                    cmap[i][j] = 'R';
                } else {
                    cmap[i][j] = s.charAt(j);
                }
            }
        }

        visited = new boolean[n][n];
        cvisited = new boolean[n][n];
        count = 0;
        ccount = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(!visited[i][j]) {

                    dfs(i, j, visited, map, map[i][j]);
                    count++;
                }

                if(!cvisited[i][j]) {

                    dfs(i, j, cvisited, cmap, cmap[i][j]);
                    ccount++;
                }
            }
        }

        System.out.println(count + " " + ccount);
    }

    public static void dfs(int x, int y, boolean[][] visited, char[][] map, char color) {

        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] == color) {

                dfs(nx, ny, visited, map, color);
            }
        }
    }
}
