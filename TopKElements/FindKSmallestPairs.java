package TopKElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKSmallestPairs {

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> resultPairs = new ArrayList<>();

        // 1. Generate all pairs
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                resultPairs.add(Arrays.asList(num1, num2));
            }
        }

        // 2. sort them by sum
        Collections.sort(resultPairs, (a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

        // 3. find first k pairs
        return resultPairs.subList(0, Math.min(k, resultPairs.size()));

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;

        FindKSmallestPairs findKSmallestPairs = new FindKSmallestPairs();

        System.out.println(findKSmallestPairs.kSmallestPairs(nums1, nums2, k));
    }
}
