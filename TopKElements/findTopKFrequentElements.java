package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class findTopKFrequentElements {

    private static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];

        // 1. Store the count of every number | (num, count)
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num : nums){
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        // 2. Convert map into list and sort in descending order
        List<Map.Entry<Integer, Integer>> cntList = new ArrayList<>(cntMap.entrySet());
        cntList.sort((a,b)-> b.getValue() - a.getValue());

        // 3. find top k elements
        for(int i=0; i<k; i++){
            result[i] = cntList.get(i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        int k = 2;

        int[] result = topKFrequent(input, k);
        for(int num: result){
            System.out.print(num + " ");
        }
    }
}
