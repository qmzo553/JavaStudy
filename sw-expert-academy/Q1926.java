import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            String str = i + "";

            if(str.contains("3") || str.contains("6") || str.contains("9")) {
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                        sb.append("-");
                    }
                }
                sb.append(" ");
            } else {
                sb.append(str).append(" ");
            }
        }

        System.out.println(sb);
    }
}
