class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Map 1D index to 2D matrix coordinates
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false; // Target not found
    }
}
