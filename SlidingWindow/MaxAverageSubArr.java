package SlidingWindow;

public class MaxAverageSubArr {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double avg = (double) sum / k;
            max = Math.max(max, avg);
        }
        return max;
    }
}
