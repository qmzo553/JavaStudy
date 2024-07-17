import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1406 {

	private static String init, cmd;
	private static int count;
	private static Stack<Character> stack = new Stack<>();
	private static Stack<Character> subStack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		init = br.readLine();
		for(int i = 0; i < init.length(); i++) {
			subStack.push(init.charAt(i));
		}

		count = Integer.parseInt(br.readLine());
		while(count-- > 0) {
			st = new StringTokenizer(br.readLine());

			cmd = st.nextToken();
			char ch = 0;
			if(st.hasMoreTokens()) {
				ch = st.nextToken().charAt(0);
			}

			switch(cmd) {
				case "L": left();
					break;
				case "D": right();
					break;
				case "B": delete();
					break;
				case "P": insert(ch);
					break;

					default: break;
			}
		}

		while(!subStack.empty()) {
			stack.push(subStack.pop());
		}

		while(!stack.empty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}

	private static void left() {
		if(!subStack.isEmpty()) {
			stack.push(subStack.pop());
		}
	}

	private static void right() {
		if(!stack.isEmpty()) {
			subStack.push(stack.pop());
		}
	}

	private static void delete() {
		if(!subStack.isEmpty()) {
			subStack.pop();
		}
	}

	private static void insert(char ch) {
		subStack.push(ch);
	}
}
