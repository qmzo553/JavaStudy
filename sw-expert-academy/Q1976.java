import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");

            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int h = h1 + h2;
            int m = m1 + m2;

            if(m >= 60) {
                h++;
                m -= 60;
            }

            if(h > 12) {
                h -= 12;
            }

            sb.append(h).append(" ").append(m).append("\n");
        }

        System.out.println(sb);
    }
}
