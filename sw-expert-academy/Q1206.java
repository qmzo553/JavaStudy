import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test = 0;
        while(test++ < 10) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for(int i = 2; i < n - 2; i++) {
                int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));

                if(arr[i] - max > 0) {
                    cnt += arr[i] - max;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
