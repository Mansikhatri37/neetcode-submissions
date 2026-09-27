class Solution {
    private final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Mark as visited

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(newRow, newCol, board);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board); // Left border
            if (board[i][n - 1] == 'O') dfs(i, n - 1, board); // Right border
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, board); // Top border
            if (board[m - 1][j] == 'O') dfs(m - 1, j, board); // Bottom border
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // Surrounded regions
                else if (board[i][j] == 'T') board[i][j] = 'O'; // Border-connected regions
            }
        }
    }
}
