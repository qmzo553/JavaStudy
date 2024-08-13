import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int move = 0;
        Stack<Integer>[] stack = new Stack[7];

        for(int i = 0; i <= 6; i++){
            stack[i] = new Stack<>();
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int lineNum = Integer.parseInt(st.nextToken());
            int pretNum = Integer.parseInt(st.nextToken());

            while(!stack[lineNum].isEmpty() && stack[lineNum].peek() > pretNum){
                stack[lineNum].pop();
                move++;
            }

            if(stack[lineNum].isEmpty() || stack[lineNum].peek() < pretNum){
                stack[lineNum].push(pretNum);
                move++;
            }
        }

        System.out.println(move);
    }
}
