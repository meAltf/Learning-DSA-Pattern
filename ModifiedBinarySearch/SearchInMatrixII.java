package ModifiedBinarySearch;

public class SearchInMatrixII {

    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
