import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1221 {

    private static String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            String test = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            String[] inputs = new String[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                inputs[i] = st.nextToken();
            }

            Arrays.sort(inputs, (o1, o2) -> {
                int idx1 = 0;
                int idx2 = 0;

                for(int i = 0; i < numbers.length; i++) {
                    if(numbers[i].equals(o1)) {
                        idx1 = i;
                    }

                    if(numbers[i].equals(o2)) {
                        idx2 = i;
                    }
                }

                return idx1 - idx2;
            });

            StringBuilder sb2 = new StringBuilder();
            for(String s : inputs) {
                sb2.append(s).append(" ");
            }

            sb.append(test).append("\n").append(sb2).append("\n");
        }

        System.out.println(sb);
    }
}
