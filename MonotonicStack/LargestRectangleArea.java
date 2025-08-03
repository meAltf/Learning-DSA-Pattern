package MonotonicStack;

public class LargestRectangleArea {

    private static int calculateRectangleArea(int height) {
        return height; // bcz width is given 1 always in the problem statement.
    }

    private static int largestRectangleBruteForce(int[] heights) {
        int maxArea = Integer.MIN_VALUE, n = heights.length;

        for (int i = 0; i < n; i++) {
            int min = heights[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, heights[j]);
                int width = j - i + 1;
                int area = min * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int[] input = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleBruteForce(input);

        System.out.println(result);
    }
}
