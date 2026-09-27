class Solution {

    private int[] parent;
    private int[] rank;

    public int find(int x){
        
        //used to find the parent of the element
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){

        int parentX = find(x);
        int parentY = find(y);

        if(parentX != parentY){

            if(rank[parentX] > rank[parentY]){

                parent[parentY] = parentX; 
            }
            else if(rank[parentY] > rank[parentX]){

                parent[parentX] = parentY;
            }
            else{
            parent[parentY] = parentX;
            rank[parentX]++;
            
            }
        }
    }

    public int countComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        HashSet<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is its own parent
            rank[i] = 1;   // Initial rank is 1
        }

        // Process all edges to perform unions
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        for(int i = 0 ; i < n ; i++){

            st.add(find(i));
        }

        return st.size();
    }
}
