import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1970 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append("\n");

            int n = Integer.parseInt(br.readLine());

            if(n < 50000) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 50000).append(" ");
                n %= 50000;
            }

            if(n < 10000) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 10000).append(" ");
                n %= 10000;
            }

            if(n < 5000) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 5000).append(" ");
                n %= 5000;
            }

            if(n < 1000) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 1000).append(" ");
                n %= 1000;
            }

            if(n < 500) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 500).append(" ");
                n %= 500;
            }

            if(n < 100) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 100).append(" ");
                n %= 100;
            }

            if(n < 50) {
                sb.append(0).append(" ");
            } else {
                sb.append(n / 50).append(" ");
                n %= 50;
            }

            if(n < 10) {
                sb.append(0).append(System.lineSeparator());
            } else {
                sb.append(n / 10).append(System.lineSeparator());
            }
        }

        System.out.println(sb);
    }
}
