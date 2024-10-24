import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
