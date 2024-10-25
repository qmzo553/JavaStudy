import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2007 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            String str = br.readLine();
            int ans = findPattern(str);

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static int findPattern(String str) {
        for(int i = 1; i <= 10; i++) {
            String pattern = str.substring(0, i);
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < str.length() / i; j++) {
                sb.append(pattern);
            }

            if(sb.toString().equals(str.substring(0, sb.length()))) {
                return i;
            }
        }

        return 30;
    }
}
