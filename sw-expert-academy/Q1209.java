import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1209 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");

            int[][] arr = new int[100][100];
            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int sumR = 0;
            int sumC = 0;
            int sumD1 = 0;
            int sumD2 = 0;

            for(int i = 0; i < 100; i++) {
                int temp = 0;
                for(int j = 0; j < 100; j++) {
                    temp += arr[i][j];
                }

                sumR = Math.max(sumR, temp);
            }

            for(int i = 0; i < 100; i++) {
                int temp = 0;
                for(int j = 0; j < 100; j++) {
                    temp += arr[j][i];
                }

                sumC = Math.max(sumC, temp);
            }

            for(int i = 0; i < 100; i++) {
                sumD1 += arr[i][i];
            }

            for(int i = 0; i < 100; i++) {
                sumD2 += arr[i][99 - i];
            }

            int result = Math.max(sumR, Math.max(sumC, Math.max(sumD1, sumD2)));
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
