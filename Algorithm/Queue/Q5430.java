import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q5430 {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();

			Deque<Integer> deque = new LinkedList<>();

			if(arr.length() > 2) {
				String[] split = arr.substring(1, arr.length() - 1).split(",");
				for (String s : split) {
					deque.addLast(Integer.parseInt(s));
				}
			}

			boolean reverseFlag = false;
			boolean errorFlag = false;
			for(int i = 0; i < p.length(); i++) {
				char ch = p.charAt(i);

				if(ch == 'R') {
					reverseFlag = !reverseFlag;
				} else if(ch == 'D') {
					if(deque.isEmpty()) {
						errorFlag = true;
						break;
					}

					if(reverseFlag) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}

			if(errorFlag) {
				sb.append("error").append("\n");
			} else {
				print(deque, reverseFlag);
			}
		}

		System.out.print(sb);
	}

	public static void print(Deque<Integer> deque, boolean reverseFlag) {
		if(deque.isEmpty()) {
			sb.append("[]").append("\n");
			return;
		}

		sb.append("[");
		int size = deque.size();
		if(reverseFlag) {
			for(int i = 0; i < size - 1; i++) {
				sb.append(deque.pollLast()).append(",");
			}
		} else {
			for(int i = 0; i < size - 1; i++) {
				sb.append(deque.pollFirst()).append(",");
			}
		}

		sb.append(deque.poll()).append("]").append("\n");
	}
}
