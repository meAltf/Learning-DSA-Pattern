package FastSlowPointers;

public class FindDuplicateNum {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
            if (count > 1) return nums[i];
        }
        return -1;
    }
}
