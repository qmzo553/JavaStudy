import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long ans = 0;

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[n - 1];

            for(int i = n - 2; i >= 0; i--) {
                if(arr[i] <= max) {
                    ans += max - arr[i];
                } else {
                    max = arr[i];
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
