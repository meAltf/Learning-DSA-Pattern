package TwoPointers;

import java.util.*;

public class ThreeSumBruteForce {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // sort to avoid duplicates
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList(result);
    }
}
