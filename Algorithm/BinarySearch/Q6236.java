import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6236 {

    public static int n, m;
    public static int[] money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        money = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            if(money[i] > max) max = money[i];
        }

        int start = max;
        int end = 10_000 * 100_000;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            int cnt = 1;
            int nowMoney = mid;
            for(int i = 0; i < n; i++) {
                if(nowMoney - money[i] < 0) {
                    nowMoney = mid;
                    cnt += 1;
                }

                nowMoney -= money[i];
            }

            if(cnt > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
