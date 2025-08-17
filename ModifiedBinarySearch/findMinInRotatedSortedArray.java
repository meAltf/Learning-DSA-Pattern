package ModifiedBinarySearch;

public class findMinInRotatedSortedArray {

    private static int finPivotBS(int[] nums) {
        int low = 0, high = nums.length - 1;

        // in case no rotation means array in sorted order
        if (nums[0] <= nums[high]) return 0;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else high = mid;
        }
        return low;
    }

    private static int findMin(int[] nums) {

        int pivotIdx = finPivotBS(nums);

        if (pivotIdx == 0) return nums[0];

        return Math.min(nums[0], nums[pivotIdx]);
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 9, 1, 2};

        int result = findMin(input);
        System.out.println("Min value in array is: " + result);
    }
}
