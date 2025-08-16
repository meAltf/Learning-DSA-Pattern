package ModifiedBinarySearch;

public class SearchInRotatedSortedArrayOptimal {

    private static int findPivot(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                return i;
            }
        }
        return 0;
    }

    private static int BinarySearch(int[] nums, int low, int high, int target) {
        int idx = -1;

        while (low <= high) {
            int mid = mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int searchOptimal(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int pivotIdx = findPivot(nums);

        if (pivotIdx == 0) return BinarySearch(nums, 0, n - 1, target);

        // which part needs to be search
        if (nums[0] > target) {
            return BinarySearch(nums, pivotIdx, n - 1, target);
        } else {
            return BinarySearch(nums, 0, pivotIdx - 1, target);
        }
    }


    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;

        int result = searchOptimal(input, target);
        System.out.println("Index of the target is: " + result);
    }
}
