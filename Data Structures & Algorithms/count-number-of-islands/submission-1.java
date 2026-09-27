class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private boolean isSafe(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1';
    }

    private void bfs(char[][] grid, int i, int j, Queue<int[]> q) {

        q.offer(new int[]{i, j});
        
        grid[i][j] = '0';
        
       while(!q.isEmpty()){
         
         int [] curr = q.poll();

         for(int[] p : dir){
            int i_ = curr[0] + p[0];
            int j_ = curr[1] + p[1];

            if(isSafe(grid, i_, j_)){
                q.offer(new int[] {i_,j_});
                grid[i_][j_] = '0';
            }
         }
       }
    }
    public int numIslands(char[][] grid) {
         if(grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j, q);
                    count++;
                }
            }
        }
        
        return count;
    }
}
