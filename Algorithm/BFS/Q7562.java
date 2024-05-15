import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {

    private static int t, size, startX, startY, endX, endY;
    private static boolean[][] visited;
    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            size = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            sb.append(bfs() + "\n");
        }

        System.out.println(sb);
    }

    public static int bfs() {
        if (startX == endX && startY == endY) {
            return 0;
        }

        visited = new boolean[size][size];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCount = now[2];

            for (int i = 0; i < 8; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if (newX == endX && newY == endY) {
                    return nowCount + 1;
                }

                if (newX >= 0 && newX < size && newY >= 0 && newY < size && !visited[newX][newY]) {
                    q.add(new int[]{newX, newY, nowCount + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}
