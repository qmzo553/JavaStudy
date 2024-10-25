import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append("\n");

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                arr[i][0] = 1;
                arr[i][i] = 1;

                if(i >= 2) {
                    for(int j = 1; j < n; j++) {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] > 0) {
                        sb.append(arr[i][j]).append(" ");
                    }
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
