package ModifiedBinarySearch;

public class SearchInRotatedSortedArray {

    private static int search(int[] nums, int target) {
        int n = nums.length, idx = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (nums[j] == target) {
                    idx = j;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = search(input, target);
        System.out.println("Index of the target is: " + result);
    }
}
