import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16713 {

    public static int n, q;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixArr[i + 1] = prefixArr[i] ^ arr[i];
        }

        int start, end;
        int result = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());


            result = result ^ (prefixArr[end] ^ prefixArr[start - 1]);
        }

        System.out.println(result);
    }
}
