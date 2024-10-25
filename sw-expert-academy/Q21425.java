import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int count = 0;
            while (true) {
                if(a > b) {
                    b += a;
                    count++;
                } else {
                    a += b;
                    count++;
                }

                if(a > n || b > n) {
                    break;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
