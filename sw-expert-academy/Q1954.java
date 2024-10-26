import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1954 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append("\n");

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int dir = 0;
            int nx = 0;
            int ny = 0;

            for(int i = 1; i <= n * n; i++) {
                arr[nx][ny] = i;

                if(nx + dx[dir] >= n || ny + dy[dir] >= n || nx + dx[dir] < 0 || ny + dy[dir] < 0 || arr[nx + dx[dir]][ny + dy[dir]] != 0) {
                    dir = (dir + 1) % 4;
                }

                nx += dx[dir];
                ny += dy[dir];
            }

            for(int i = 0; i < n; i++) {
                for(int num : arr[i]) {
                    sb.append(num).append(" ");
                }
                sb.append(System.lineSeparator());
            }
        }

        System.out.println(sb);
    }
}
