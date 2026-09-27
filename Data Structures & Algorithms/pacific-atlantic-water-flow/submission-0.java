
class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // Separate DFS function
    public void dfs(int row, int col, boolean[][] reachable, int[][] heights, int rows, int cols) {
        reachable[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check bounds and conditions
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    !reachable[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, reachable, heights, rows, cols);
            }
        }
    }

    // Main function to find the cells that can flow to both oceans
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // Matrices to keep track of visited cells for each ocean
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Start DFS from Pacific Ocean border cells
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacificReachable, heights, rows, cols); // Left column
            dfs(r, cols - 1, atlanticReachable, heights, rows, cols); // Right column
        }
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacificReachable, heights, rows, cols); // Top row
            dfs(rows - 1, c, atlanticReachable, heights, rows, cols); // Bottom row
        }

        // Collect cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }

        return result;
    }
}
