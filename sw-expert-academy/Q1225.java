import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            int n = Integer.parseInt(br.readLine());
            int count = 1;
            Queue<Integer> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            while(true) {
                int cnt = q.poll() - count;

                if(cnt <= 0) {
                    q.offer(0);
                    break;
                } else {
                    q.offer(cnt);
                }

                count = (count % 5) + 1;
            }

            for(int num : q) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
