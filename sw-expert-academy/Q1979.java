import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            int[][] arr = new int[n][n];

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int l = 0; l < n; l++) {
                    arr[j][l] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0; j < n; j++) {
                int temp = 0;
                for(int l = 0; l < n; l++) {
                    if(arr[j][l] == 1) {
                        temp++;
                    } else {
                        if(temp == k) {
                            count++;
                        }

                        temp = 0;
                    }
                }

                if(temp == k) {
                    count++;
                }
            }

            for(int j = 0; j < n; j++) {
                int temp = 0;
                for(int l = 0; l < n; l++) {
                    if(arr[l][j] == 1) {
                        temp++;
                    } else {
                        if(temp == k) {
                            count++;
                        }

                        temp = 0;
                    }
                }

                if(temp == k) {
                    count++;
                }
            }

            sb.append(count).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
