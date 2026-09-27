
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // Priority queue to store [time, row, col], sorted by time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s[0]));

        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Visited array to avoid re-processing cells
        boolean[][] visited = new boolean[n][n];

        // Start from the top-left corner
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0]; // Current water level
            int i = curr[1];    // Current row
            int j = curr[2];    // Current column

            // If we reach the bottom-right corner, return the time
            if (i == n - 1 && j == n - 1) return time;

            // Explore all 4 directions
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                // Check bounds and if the cell is already visited
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    // Add the max of the current time and the next cell's height
                    pq.offer(new int[]{Math.max(time, grid[ni][nj]), ni, nj});
                }
            }
        }

        return -1; // This line should never be reached if the input is valid
    }
}
