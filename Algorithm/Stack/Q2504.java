import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int sum = 0;
		int tmp = 1;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(') {
				stack.push(ch);
				tmp *= 2;
			} else if (ch == '[') {
				stack.push(ch);
				tmp *= 3;
			} else if (ch == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					sum = 0;
					break;
				} else {
					if (str.charAt(i - 1) == '(') {
						sum += tmp;
					}
					stack.pop();
					tmp /= 2;
				}
			} else if (ch == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					sum = 0;
					break;
				} else {
					if (str.charAt(i - 1) == '[') {
						sum += tmp;
					}
					stack.pop();
					tmp /= 3;
				}
			}
		}

		if (!stack.isEmpty()) {
			sum = 0;
		}

		System.out.println(sum);
	}
}
