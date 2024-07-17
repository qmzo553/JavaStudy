import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q15828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();


		int input = 0;
		while(input != -1) {
			input = Integer.parseInt(br.readLine());
			if(input == -1) {
				continue;
			}

			if(input == 0) {
				q.poll();
				continue;
			}

			if(q.size() == N) {
				continue;
			}

			q.add(input);
		}

		if(q.isEmpty()) {
			sb.append("empty");
		} else {
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
		}

		System.out.println(sb);
	}
}
