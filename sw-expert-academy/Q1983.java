import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1983 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;
        String[] score = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            double[] arr = new double[n];
            double totalK = 0;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int middle = Integer.parseInt(st.nextToken());
                int finals = Integer.parseInt(st.nextToken());
                int task = Integer.parseInt(st.nextToken());
                double total = middle * 0.35 + finals * 0.45 + task * 0.2;

                arr[i] = total;
                if(i == k - 1) {
                    totalK = total;
                }
            }

            Arrays.sort(arr);
            int rank = 0;
            for(int i = 0; i < n; i++) {
                rank++;
                if(arr[i] == totalK) {
                    break;
                }
            }

            int scoreIndex = (rank - 1) / (n / 10);
            sb.append(score[scoreIndex]).append("\n");
        }

        System.out.println(sb);
    }
}
