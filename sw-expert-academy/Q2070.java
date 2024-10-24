import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            if(a > b) {
                sb.append(">").append("\n");
            } else if(a < b) {
                sb.append("<").append("\n");
            } else {
                sb.append("=").append("\n");
            }
        }

        System.out.println(sb);
    }
}
