import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14425 {

    public static int n, m;
    public static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        String search;
        int count = 0;
        for(int i = 0; i < m; i++) {
            search = br.readLine();

            if(binarySearch(arr, search)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean binarySearch(String[] arr, String target) {
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid].equals(target)) {
                return true;
            }

            if(arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else if(arr[mid].compareTo(target) > 0) {
                right = mid - 1;
            }
        }

        return false;
    }
}
