import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int i = 1; i <= n; i++) {
                if(i % 2 == 0) {
                    sum -= i;
                } else {
                    sum += i;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
