import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5427 {

    public static int t, h, w, result;
    public static char[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<int[]> fire;
    public static Queue<int[]> person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fire = new LinkedList<>();
            person = new LinkedList<>();

            for(int i = 0; i < h; i++) {
                String str = br.readLine();
                for(int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);

                    if(map[i][j] == '@') {
                        person.add(new int[]{i, j, 0});
                    } else if(map[i][j] == '*') {
                        fire.add(new int[]{i, j, 0});
                    }
                }
            }

            result = 0;
            bfs();

            if(result == 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(result + "\n");
            }
        }

        System.out.println(sb);
    }

    public static void bfs() {
        while(!person.isEmpty()) {
            int size = fire.size();
            for(int i = 0; i < size; i++) {
                int[] now = fire.poll();
                int nowX = now[0];
                int nowY = now[1];

                for(int j = 0; j < 4; j++) {
                    int newX = nowX + dx[j];
                    int newY = nowY + dy[j];

                    if(newX >= 0 && newX < h && newY >= 0 && newY < w) {
                        if(map[newX][newY] == '.' || map[newX][newY] == '@') {
                            map[newX][newY] = '*';
                            fire.add(new int[]{newX, newY, 0});
                        }
                    }
                }
            }

            size = person.size();
            for(int i = 0; i < size; i++) {
                int[] now = person.poll();
                int nowX = now[0];
                int nowY = now[1];
                int nowCount = now[2];

                for(int j = 0; j < 4; j++) {
                    int newX = nowX + dx[j];
                    int newY = nowY + dy[j];

                    if(newX < 0 || newX >= h || newY < 0 || newY >= w) {
                        result = nowCount + 1;
                        return;
                    }

                    if(map[newX][newY] == '.') {
                        map[newX][newY] = '@';
                        person.add(new int[]{newX, newY, nowCount + 1});
                    }
                }
            }
        }
    }
}
