package FastSlowPointers;

public class FindDuplicateOptimized {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0], fast = nums[0];

        // 1. find intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 2. find entrance of cycle | duplicate num
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
