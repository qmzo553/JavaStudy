import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {

    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int res1 = arr[left];
        int res2 = arr[right];

        while (left < right) {

            int value = arr[left] + arr[right];

            if (Math.abs(value) < min) {
                min = Math.abs(value);
                res1 = arr[left];
                res2 = arr[right];

                if(value == 0) break;
            }

            if(value > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(res1 + " " + res2);
    }
}
