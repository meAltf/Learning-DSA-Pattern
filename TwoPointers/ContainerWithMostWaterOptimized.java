package TwoPointers;

public class ContainerWithMostWaterOptimized {

    public int maxArea(int[] height) {
        int max = 0, n = height.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            int area = length * width;
            max = Math.max(max, area);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return max;
    }
}
