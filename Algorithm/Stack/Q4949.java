import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;

		while(true) {
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}

			stack = new Stack<>();
			boolean flag = true;

			for(Character c : str.toCharArray()) {
				if(c == '(' || c == '[') {
					stack.push(c);
				} else if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					}
					stack.pop();
				} else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					}
					stack.pop();
				}
			}

			if(!stack.isEmpty()) {
				flag = false;
			}

			if(flag) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}

		System.out.println(sb);
	}
}
