import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1860 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(times);

            int time = 0;
            int cnt = 0;
            int count = 0;
            int index = 0;
            String result = "Possible";
            while(time <= times[n - 1]) {
                if(cnt == m) {
                    count += k;
                    cnt = 0;
                }

                if(times[index] == time) {
                    count--;
                    index++;
                }

                if(count < 0) {
                    result = "Impossible";
                    break;
                }

                time++;
                cnt++;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
