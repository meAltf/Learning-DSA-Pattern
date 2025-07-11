package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int maxCnt = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt0 = 0, cnt1 = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) cnt0++;
                else cnt1++;

                if (cnt0 == cnt1) {
                    maxCnt = Math.max(maxCnt, j - i + 1);
                }
            }
        }
        return maxCnt;
    }
}
