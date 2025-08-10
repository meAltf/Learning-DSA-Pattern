package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKSmallestPairsOptimized {

    static class PairSum {
        int a;
        int b;
        int sum;

        public PairSum(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        PriorityQueue<PairSum> resultPairsHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                PairSum pairSum = new PairSum(nums1[i], nums2[j], nums1[i] + nums2[j]);

                if (resultPairsHeap.size() < k) {
                    resultPairsHeap.offer(pairSum);
                } else if (resultPairsHeap.peek().sum > pairSum.sum) {
                    resultPairsHeap.poll();
                    resultPairsHeap.offer(pairSum);
                } else {
                    break; // // This must be noted that the once the sum exceeds the heap top we dont want to traverse completly till the j pointer till the end..
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!resultPairsHeap.isEmpty()) {
            PairSum pollPairSum = resultPairsHeap.poll();
            List<Integer> list = new ArrayList<>();
            list.add(pollPairSum.a);
            list.add(pollPairSum.b);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 2;

        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}
