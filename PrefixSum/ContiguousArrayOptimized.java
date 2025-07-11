package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayOptimized {

    public int findMaxLength(int[] nums) {
        int max = 0;
        // step 1 : modify the array | 0 to -1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        // step 2 : count subarray with sum = 0
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                max = Math.max(max, len);
            } else {
                map.put(sum, i); // store first occurences
            }
        }
        return max;

    }
}
