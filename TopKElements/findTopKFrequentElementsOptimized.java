package TopKElements;

import java.util.*;


public class findTopKFrequentElementsOptimized {

    private static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];

        // 1. Store the count of every number | (num, count)
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        // 2. Min-head based on count of num | Add entries in map
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3. Extract top k elements
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(input, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
