import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1984 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            int[] arr = new int[10];
            st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for(int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            for(int i = 0; i < 10; i++) {
                if(arr[i] == max || arr[i] == min) {
                    continue;
                }

                sum += arr[i];
            }

            sb.append(Math.round(sum / 8.0)).append("\n");
        }

        System.out.println(sb);
    }
}
