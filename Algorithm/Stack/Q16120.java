import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q16120 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();

		for(Character c : str.toCharArray()) {
			stack.push(c);

			if(stack.size() >= 4) {
				if (stack.get(stack.size() - 4) == 'P' &&
					stack.get(stack.size() - 3) == 'P' &&
					stack.get(stack.size() - 2) == 'A' &&
					stack.get(stack.size() - 1) == 'P') {

					for (int i = 0; i < 4; i++) {
						stack.pop();
					}

					stack.push('P');
				}
			}
		}

		if(stack.size() == 1 && stack.peek() == 'P') {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}
}
