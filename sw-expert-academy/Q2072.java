import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            while(st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());

                if(a % 2 > 0) {
                    sum += a;
                }
            }

            sb.append("#" + count++ + " " + sum + "\n");
        }

        System.out.println(sb);
    }
}
