import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1289 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            String str = br.readLine();
            char c = str.charAt(0);
            int count = c - '0';

            for(int i = 0; i < str.length(); i++) {
                if(c != str.charAt(i)) {
                    count++;
                    c = str.charAt(i);
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
