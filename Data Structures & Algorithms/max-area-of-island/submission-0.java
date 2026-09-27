class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean isSafe(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!isSafe(grid, i, j)) return 0;

        // Mark the current cell as visited
        grid[i][j] = 0;

        int count = 1; // Start with the current cell
        for (int[] neighbour : dir) {
            int i_ = i + neighbour[0];
            int j_ = j + neighbour[1];
            count += dfs(grid, i_, j_); // Add area of connected cells
        }

        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int max = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // If it's part of an island
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }
}
