package TopKElements;

import java.util.PriorityQueue;

public class findKthSmallestElementOptimized {

    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (b - a));

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int result = findKthSmallest(input, 3);

        System.out.println(result);
    }
}
