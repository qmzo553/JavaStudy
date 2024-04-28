import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17232 {

    private static int n, m, t, k, a, b;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        String line;
        for(int i = 1; i <= n; i++) {
            line = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        int[][] sum = new int[n + 1][m + 1];
        for(int time = 0; time < t; time++) {
            // 시간이 흐를때마다 누적합 -> 생명의 수 계산
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                    if(map[i][j] == '*') {
                        sum[i][j]++;
                    }
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    int r1 = Math.max(i - k, 1);
                    int c1 = Math.max(j - k, 1);
                    int r2 = Math.min(i + k, n);
                    int c2 = Math.min(j + k, m);

                    int around = sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
                    if(map[i][j] == '*') {
                        around--;
                    }

                    if(map[i][j] == '*') {
                        if(around < a || around > b) {
                            map[i][j] = '.';
                        } else {
                            map[i][j] = '*';
                        }
                    } else {
                        if(around > a && around <= b) {
                            map[i][j] = '*';
                        } else {
                            map[i][j] = '.';
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
