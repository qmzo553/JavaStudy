import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2046 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            sb.append("#");
        }

        System.out.println(sb);
    }
}
