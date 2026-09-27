
class Solution {
    public boolean dfs(int u, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;

        for (int nei : adj.get(u)) {
            if (nei == parent) continue; // Skip the edge leading to the parent
            if (visited[nei]) return true; // Cycle detected
            if (dfs(nei, u, adj, visited)) return true;
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); // Initialize each list
        }

        // Process edges and check for cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Add the edge to the adjacency list
            adj.get(u).add(v);
            adj.get(v).add(u);

            // Reset visited array for each edge
            boolean[] visited = new boolean[n + 1];

            // Check if adding this edge creates a cycle
            if (dfs(u, -1, adj, visited)) {
                return edge; // This edge is redundant
            }

        }

        return new int[0];
    }
}
