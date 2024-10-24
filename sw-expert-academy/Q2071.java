import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2071 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while (t-- > 0) {
            sb.append("#").append(count++).append(" ");

            st = new StringTokenizer(br.readLine());
            int sum = 0;
            while(st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }

            sb.append(Math.round(sum / 10.0)).append("\n");
        }

        System.out.println(sb);
    }
}
