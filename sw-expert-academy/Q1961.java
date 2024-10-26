import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append("\n");

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] arr90 = rotation(arr);
            int[][] arr180 = rotation(arr90);
            int[][] arr270 = rotation(arr180);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");

                for(int j = 0; j < n; j++) {
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");

                for(int j = 0; j < n; j++) {
                    sb.append(arr270[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int[][] rotation(int[][] arr) {
        int[][] result = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                result[i][j] = arr[arr.length - 1 - j][i];
            }
        }

        return result;
    }
}
