import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {

    public static int k, n;
    public static int[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lines = new int[k];
        long max = 0;

        for(int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        max++;
        long min = 0;
        long mid = 0;
        while(min < max) {
            mid = min + (max - min) / 2;
            long count = 0;

            for(int line : lines) {
                count += (line / mid);
            }

            if(count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max - 1);
    }
}

