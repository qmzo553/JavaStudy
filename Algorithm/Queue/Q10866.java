import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10866 {

	public static int pl = 10000;
	public static int pr = 10001;
	public static int[] deque = new int[20001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = 0;

			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}

			switch (str) {
				case "push_front" :
					pushFront(num);
					break;
				case "push_back" :
					pushBack(num);
					break;
				case "pop_front" :
					sb.append(popFront()).append('\n');
					break;
				case "pop_back" :
					sb.append(popBack()).append('\n');
					break;
				case "size" :
					sb.append(size()).append('\n');
					break;
				case "empty" :
					sb.append(empty()).append('\n');
					break;
				case "front" :
					sb.append(front()).append('\n');
					break;
				case "back" :
					sb.append(back()).append('\n');
					break;
			}
		}

		System.out.println(sb);
	}

	public static void pushFront(int num) {
		deque[pr] = num;
		pr++;
	}

	public static void pushBack(int num) {
		deque[pl] = num;
		pl--;
	}

	public static int popFront() {
		if(pr - pl == 1) return -1;

		int num = deque[pr - 1];
		pr--;

		return num;
	}

	public static int popBack() {
		if(pr - pl == 1) return -1;

		int num = deque[pl + 1];
		pl++;

		return num;
	}

	public static int size() {
		return pr - pl - 1;
	}

	public static int empty() {
		if(pr - pl == 1) return 1;
		else return 0;
	}

	public static int front() {
		if(pr - pl == 1) return -1;
		else return deque[pr - 1];
	}

	public static int back() {
		if(pr - pl == 1) return -1;
		else return deque[pl + 1];
	}
}
