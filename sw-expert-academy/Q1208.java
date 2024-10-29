import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test = 0;
        while(test++ < 10) {
            sb.append("#").append(test).append(" ");

            int dump = Integer.parseInt(br.readLine());
            int[] arr = new int[100];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            while(dump-- > 0) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }

            Arrays.sort(arr);

            sb.append(arr[99] - arr[0]).append("\n");
        }

        System.out.println(sb);
    }
}
