import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        for(int i = 1; i <= n / 2; i++) {
            if(n % i == 0) {
                arr[i] = 1;
                arr[n / i] = 1;
            }
        }

        for(int i = 1; i < 1001; i++) {
            if(arr[i] == 1) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
