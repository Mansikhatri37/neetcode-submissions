
class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean isSafe(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }

    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = 0; // Mark as visited

        int count = 1; // Start with the current cell

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] p : dir) {
                int i_ = curr[0] + p[0];
                int j_ = curr[1] + p[1];

                if (isSafe(grid, i_, j_)) {
                    q.offer(new int[]{i_, j_});
                    grid[i_][j_] = 0; // Mark as visited
                    count++;
                }
            }
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
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }

        return max;
    }
}
