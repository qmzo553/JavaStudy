import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++) {
                String ii = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for(int j = 0; j < y; j++) {
                    list.add(x, Integer.parseInt(st.nextToken()));
                    x++;
                }
            }

            for(int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
