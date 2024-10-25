import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int count = 1;

        while(t-- > 0) {
            sb.append("#").append(count++).append(" ");

            String str = br.readLine();
            boolean flag = false;

            for(int i = 0; i < str.length() / 2; i++) {
                if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                sb.append(0).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
