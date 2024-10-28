import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            int[] arr = new int[101];
            int max = 0;
            int index = 0;
            int testNum = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 1000; i++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            for(int i = 100; i > 0; i--) {
                if(arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }

            sb.append(index).append("\n");
        }

        System.out.println(sb);
    }
}
