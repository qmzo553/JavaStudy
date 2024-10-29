import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1244 {

    private static int change;
    private static int max = Integer.MIN_VALUE;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            change = Integer.parseInt(st.nextToken());
            numbers = new int[str.length()];

            for(int i = 0; i < str.length(); i++) {
                numbers[i] = str.charAt(i) - '0';
            }

            if (numbers.length < change) {
                change = numbers.length;
            }

            dfs( 0);

            sb.append(max).append("\n");
            max = Integer.MIN_VALUE;
        }

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == change) {
            int result = 0;
            for (int num : numbers) {
                result = result * 10 + num;
            }

            max = Math.max(max, result);
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                swap(i, j);
                dfs(depth + 1);
                swap(i, j);
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
