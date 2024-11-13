import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] a = getPoint(p);
            int[] b = getPoint(q);

            int[] ans = {a[0] + b[0], a[1] + b[1]};

            sb.append(getValue(ans)).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] getPoint(int value) {
        int count = 1;

        for(int i = 1;; i++) {
            for(int x = 1, y = i; x <= i; x++, y--) {
                if(value == count) {
                    return new int[]{x, y};
                }

                count++;
            }
        }
    }

    private static int getValue(int[] point) {
        int count = 1;

        for(int i = 1;; i++) {
            for(int x = 1, y = i; x <= i; x++, y--) {
                if(x == point[0] && y == point[1]) {
                    return count;
                }

                count++;
            }
        }
    }
}
