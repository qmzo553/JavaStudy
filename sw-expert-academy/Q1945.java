import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] arr = {2, 3, 5, 7, 11};
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");
            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < arr.length; i++) {
                int count = 0;

                while(n % arr[i] == 0) {
                    n /= arr[i];
                    count++;
                }

                sb.append(count).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
