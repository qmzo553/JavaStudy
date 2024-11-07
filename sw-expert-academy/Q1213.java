import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            br.readLine();
            String str = br.readLine();
            String search = br.readLine();
            int count = 0;

            for(int i = 0; i <= search.length() - str.length(); i++) {
                String s = search.substring(i, i + str.length());

                if(s.equals(str)) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
