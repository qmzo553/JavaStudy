import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < N; i++) {
				q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
			}

			int count = 0;

			while(!q.isEmpty()) {

				int[] cnt = q.poll();
				boolean flag = true;

				for(int[] next : q) {
					if(cnt[1] < next[1]) {
						flag = false;
						break;
					}
				}

				if(flag) {
					count++;

					if(cnt[0] == M) break;
				} else {
					q.offer(cnt);
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
