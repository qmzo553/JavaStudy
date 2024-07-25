import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			String str = br.readLine();
			Stack<Character> leftStack = new Stack<>();
			Stack<Character> rightStack = new Stack<>();

			for (char c : str.toCharArray()) {
				if (c == '<') {
					if (!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());
					}
				} else if (c == '>') {
					if (!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());
					}
				} else if (c == '-') {
					if (!leftStack.isEmpty()) {
						leftStack.pop();
					}
				} else {
					leftStack.push(c);
				}
			}

			StringBuilder sb = new StringBuilder();

			while (!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			while (!rightStack.isEmpty()) {
				sb.append(rightStack.pop());
			}

			System.out.println(sb);
		}
	}
}
