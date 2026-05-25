// 167. Two Sum II - Input Array Is Sorted | 

// Brute-force, O(n^2)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=1; i<=numbers.length; i++){
            for(int j=i+1; j<=numbers.length; j++){
                System.out.println("Iteration: i " + i + " " + numbers[i-1] + ", j "+ j +" "+ numbers[j-1]);
                if(numbers[j-1] == target-numbers[i-1]){
                    return new int[]{i,j};
                } 
            }
        }
        return new int[]{-1,-1};
    }
}

// Better approach using hashmap, means O(n) extra complexity but time complexity reduced to  O(n)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<numbers.length; i++){
            int res = target-numbers[i];

            if(map.containsKey(res)){
                return new int[]{map.get(res)+1, i+1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}
