import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            int s = 0;
            int d = 0;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());
                int a = 0;
                if(st.hasMoreTokens()) {
                    a = Integer.parseInt(st.nextToken());
                }

                if(command == 1) {
                    s += a;
                } else if(command == 2) {
                    s -= a;

                    if(s < 0) {
                        s = 0;
                    }
                }

                d += s;
            }

            sb.append(d).append("\n");
        }

        System.out.println(sb);
    }
}
