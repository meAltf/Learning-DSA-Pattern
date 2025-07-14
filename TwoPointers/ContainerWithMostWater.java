package TwoPointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0, n = height.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int width = j - i;
                int length = Math.min(height[i], height[j]);
                int area = length * width;

                max = Math.max(max, area);
            }
        }
        return max;
    }
}
