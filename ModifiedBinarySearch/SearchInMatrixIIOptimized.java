package ModifiedBinarySearch;

public class SearchInMatrixIIOptimized {

    private static boolean searchMatrix(int[][] matrix, int target) {
        // start from the top right corner | staircase-search

        // edge case
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;

        // top-right corner
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) return true;

            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] inputMat = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target1 = 5;
        int target2 = 20;

        boolean result1 = searchMatrix(inputMat, 5);
        boolean result2 = searchMatrix(inputMat, 20);

        System.out.println("Element found: " + result1);
        System.out.println("Element found: " + result2);
    }
}
