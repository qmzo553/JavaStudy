import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {

    public static int n, m;
    public static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];
        int min = 0, max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if(max < tree[i]) max = tree[i];
        }

        Arrays.sort(tree);

        while(min < max) {

            int mid = min + (max - min) / 2;
            long sum = 0;

            for(int t : tree) {

                if(t - mid > 0) {

                    sum += (t - mid);
                }
            }

            if(sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(min - 1);
    }

}
