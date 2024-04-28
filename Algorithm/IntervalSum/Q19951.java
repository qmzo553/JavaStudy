import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19951 {

    private static int n, m;
    private static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a, b, k;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            sum[a - 1] += k;
            sum[b] -= k;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sum[i + 1] += sum[i];
            sb.append(arr[i] + sum[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
