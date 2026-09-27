class Solution {
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean isSafe(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        // Initialize queue with rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to rot

        int minutes = 0;

        // BFS to rot adjacent fresh oranges
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false; // Track if any orange rots in this step

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for (int[] dir : directions) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];

                    if (isSafe(i_, j_, grid)) {
                        grid[i_][j_] = 2; // Rot the fresh orange
                        freshCount--;
                        q.add(new int[]{i_, j_});
                        rotten = true;
                    }
                }
            }

            if (rotten) minutes++; // Increment time if at least one orange rotted
        }

        return freshCount == 0 ? minutes : -1; // If freshCount > 0, not all oranges can rot
    }
}
