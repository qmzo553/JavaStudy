import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append("\n");

            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int k = Integer.parseInt(st.nextToken());

                while(k-- > 0) {
                    sb.append(str);
                    count++;

                    if(count == 10) {
                        sb.append(System.lineSeparator());
                        count = 0;
                    }
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
