package SlidingWindow;

public class MaxAverageSubArrOptimized {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max = Integer.MIN_VALUE;

        // first window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = (double) sum / k;

        // slide the window
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            double avg = (double) sum / k;
            max = Math.max(max, avg);
        }
        return max;
    }
}
