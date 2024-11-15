import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1234 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        for(int test = 1; test <= 10; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                if(stack.isEmpty() || ch != stack.peek()) {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }

            StringBuilder sb2 = new StringBuilder();
            while(!stack.isEmpty()) {
                sb2.append(stack.pop());
            }

            sb.append(sb2.reverse()).append("\n");
        }

        System.out.println(sb);
    }
}
