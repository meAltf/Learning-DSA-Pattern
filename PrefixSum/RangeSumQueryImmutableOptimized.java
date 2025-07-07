package PrefixSum;

public class RangeSumQueryImmutableOptimized {

    class NumArray {
        private int[] prefSum;

        public NumArray(int[] nums) {
            // transform nums into prefix sum array
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            this.prefSum = nums;
        }

        public int sumRange(int left, int right) {
            if (left == 0) return prefSum[right];

            return prefSum[right] - prefSum[left - 1];
        }
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
