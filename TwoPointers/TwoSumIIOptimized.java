package TwoPointers;

public class TwoSumIIOptimized {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;
            } else right--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(arr, target);

        for (int i = 0; i < 1; i++) {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
