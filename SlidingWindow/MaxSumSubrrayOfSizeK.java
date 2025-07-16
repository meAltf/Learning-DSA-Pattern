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

    private static int maxiSumSubArrSizeKOptimized(int[] nums, int k) {
        int n = nums.length, max = Integer.MIN_VALUE;
        int WindowSum = 0;

        // First window from start to end
        for (int i = 0; i < k; i++) {
            WindowSum += nums[i];
        }
        max = WindowSum;

        // slide the window
        for (int i = k; i < n; i++) {
            WindowSum = WindowSum - nums[i - k] + nums[i];
            max = Math.max(WindowSum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maximumSumSubArrOfSizeK(arr, k);
        int result2 = maxiSumSubArrSizeKOptimized(arr, k);
        System.out.println("results are: " + result + "|" + result2);
    }
}
