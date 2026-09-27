class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Check each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char element = board[i][j];

                // Skip empty cells
                if (element == '.') {
                    continue;
                }

                // Check if the current element is valid
                if (!isValidNumber(board, i, j, element)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidNumber(char[][] board, int row, int column, char num) {
        int m = board.length;
        int n = board[0].length;

        // Check the row
        for (int i = 0; i < n; i++) {
            if (board[row][i] == num && i != column) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < m; i++) {
            if (board[i][column] == num && i != row) {
                return false;
            }
        }

        // Check the 3x3 grid
        int startRow = (row / 3) * 3;
        int startCol = (column / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num && (i != row || j != column)) {
                    return false;
                }
            }
        }

        return true;
    }
}
