import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1220 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int result = 0;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < n; i++) {
                int count = 0;
                for(int j = 0; j < n; j++) {
                    if(arr[j][i] == 1) {
                        count++;
                    }

                    if(arr[j][i] == 2 && count != 0) {
                        result++;
                        count = 0;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
