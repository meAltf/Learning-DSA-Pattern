package MonotonicStack;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindNextGreaterElement1 {

    private static int findNextGreaterElement(int a, int[] nums) {
        int n = nums.length;
        int result = -1;
        int actualIdx = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == a) {
                actualIdx = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > a && i > actualIdx) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] result = new int[n1];

        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums2) {
            set.add(num);
        }

        // 1. check the number is present or not
        for (int i = 0; i < n1; i++) {
            if (set.contains(nums1[i])) {
                int curr = nums1[i];
                result[i] = findNextGreaterElement(nums1[i], nums2);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
