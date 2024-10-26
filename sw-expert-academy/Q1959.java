import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1959 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int[] brr = new int[m];
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }

            int[] srr;
            int[] lrr;
            if(n > m) {
                srr = brr;
                lrr = arr;
            } else {
                srr = arr;
                lrr = brr;
            }

            for(int i = 0; i < lrr.length - srr.length + 1; i++) {
                int sum = 0;
                for(int j = 0; j < srr.length; j++) {
                    sum += lrr[i + j] * srr[j];
                }

                max = Math.max(max, sum);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
