import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

         int t = Integer.parseInt(br.readLine());
         for(int test = 1; test <= t; test++) {
             sb.append("#").append(test).append(" ");

             int n = Integer.parseInt(br.readLine());
             int[][] farm = new int[n][n];
             for(int i = 0; i < n; i++) {
                 String str = br.readLine();
                 for(int j = 0; j < n; j++) {
                     farm[i][j] = str.charAt(j) - '0';
                 }
             }

             int start = n / 2;
             int end = n / 2;
             int sum = 0;

             for(int i = 0; i < n; i++) {
                 for(int j = start; j <= end; j++) {
                     sum += farm[i][j];
                 }

                 if(i < n / 2) {
                     start--;
                     end++;
                 } else {
                     start++;
                     end--;
                 }
             }

             sb.append(sum).append("\n");
         }

        System.out.println(sb);
    }
}
