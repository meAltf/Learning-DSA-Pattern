package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToKOptimized {

    public int subarraySum(int[] nums, int k) {
        int count = 0, n = nums.length;

        // step 1 : change into prefixSum
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        // step 2 : map of prefixSum & occurence
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case, 0 frequency 1

        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            int target = sum - k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
