// 167. Two Sum II - Input Array Is Sorted | Brute-force

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
