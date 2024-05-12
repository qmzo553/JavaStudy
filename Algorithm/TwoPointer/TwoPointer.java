public class TwoPointer {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 11, 15, 20};
        int target = 22;

        int[] result = twoSumSorted(arr, target);

        if(result[0] != -1) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println(-1);
        }
    }

    public static int[] twoSumSorted(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                return new int[]{left, right};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
