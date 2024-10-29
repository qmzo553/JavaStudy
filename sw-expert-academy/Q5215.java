import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q5215 {

    private static int n, l;
    private static int max = Integer.MIN_VALUE;
    private static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new int[]{a, b});
            }

            dfs(0, 0, 0);

            sb.append(max).append('\n');
            max = Integer.MIN_VALUE;
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int calorie, int taste) {
        if(calorie > l) {
            return;
        }

        if(start == n) {
            max = Math.max(max, taste);
            return;
        }

        dfs(start + 1, calorie + list.get(start)[1], taste + list.get(start)[0]);

        dfs(start + 1, calorie, taste);
    }
}
