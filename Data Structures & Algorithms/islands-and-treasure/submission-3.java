class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        Queue<int[]> q = new LinkedList<>();
        
        //multisource bfs
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){

                //start bfs from all the nodes that are zero
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }   
            }
        }

        if(q.size() == 0) return;

        while(!q.isEmpty()){
            //perform the bfs

            int[] node = q.poll();
            int i = node[0];
            int j = node[1];

            for(int []dir: directions){
                
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if(i_ < 0 || i_ >= m
                || j_ < 0 || j_ >= n || grid[i_][j_] != Integer.MAX_VALUE)
                continue;

                q.add(new int[] {i_,j_});

                grid[i_][j_] = grid[i][j] + 1;
            }
            
        }

    }
}
