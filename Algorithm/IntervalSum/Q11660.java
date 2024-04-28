import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11660 {
    private static int n, m;
    private static int[][] prefixArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        prefixArr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                prefixArr[i][j] = Integer.parseInt(st.nextToken()) + prefixArr[i - 1][j] + prefixArr[i][j - 1] - prefixArr[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int result = prefixArr[endX][endY] - prefixArr[startX - 1][endY] - prefixArr[endX][startY - 1] + prefixArr[startX - 1][startY - 1];
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
}
