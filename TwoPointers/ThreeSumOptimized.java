package TwoPointers;

import java.util.*;

public class ThreeSumOptimized {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[left], nums[right]);
                    //Collections.sort(triplets); // sort triplets
                    result.add(triplets);
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = threeSum(arr);

        for (List<Integer> ans : result) {
            System.out.println(ans);
        }
    }
}
