import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2295 {

    public static int n;
    public static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum.add(nums[i] + nums[j]);
            }
        }
        Collections.sort(sum);

       for(int i = n - 1; i >= 0; i--) {
           for(int j = n - 1; j >= 0; j--) {
               int result = nums[i] - nums[j];

                if(Collections.binarySearch(sum, result) >= 0) {
                    System.out.println(nums[i]);
                    return;
                }
           }
       }
    }
}
