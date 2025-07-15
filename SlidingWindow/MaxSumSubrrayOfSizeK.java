package SlidingWindow;

public class MaxSumSubrrayOfSizeK {

    private static int maximumSumSubArrOfSizeK(int[] nums, int k) {
        int n = nums.length, max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maximumSumSubArrOfSizeK(arr, k);
        System.out.println("result is: " + result);
    }
}
