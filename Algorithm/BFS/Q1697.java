import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {

    private static int n, k;
    private static boolean[] visited = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
            return;
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int size;

        while(true) {
            count++;
            size = q.size();

            for(int i = 0; i < size; i++) {
                int num = q.poll();
                visited[num] = true;

                if(num - 1 == k || num + 1 == k || num * 2 == k) {
                    return count;
                }

                if(num - 1 >= 0 && !visited[num - 1]) {
                    visited[num - 1] = true;
                    q.add(num - 1);
                }

                if(num + 1 <= 100000 && !visited[num + 1]) {
                    visited[num + 1] = true;
                    q.add(num + 1);
                }

                if(num * 2 <= 1000000 && !visited[num * 2]) {
                    visited[num * 2] = true;
                    q.add(num * 2);
                }
            }
        }
    }
}
