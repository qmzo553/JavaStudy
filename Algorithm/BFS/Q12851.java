import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12851 {

    private static int n, k, count;
    private static int[] visited = new int[1000001];
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        count = 0;

        bfs();

        System.out.println(min + "\n" + count);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(min < visited[now]) return;

            for(int i = 0; i < 3; i++) {
                int next;

                if(i == 0)  {
                    next = now + 1;
                } else if(i == 1)  {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if(next < 0 || next > 1000000) continue;

                if(next == k) {
                    min = visited[now];
                    count++;
                }

                if(visited[next] == 0 || visited[next] == visited[now] + 1) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}
