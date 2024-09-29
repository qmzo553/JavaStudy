import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int count = 0;
        String str;

        while(t-- > 0) {
            stack.clear();
            count = 0;
            str = br.readLine();

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else {
                    if(stack.isEmpty()) {
                        count++;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty() && count == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
