class Solution {

    boolean isCycleDFS(int u, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (isCycleDFS(v, u, visited, adj)) {
                    return true;
                }
            } else if (v != parent) {
                return true; // Cycle detected
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        // Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Check for cycles using DFS
        boolean[] visited = new boolean[n];
        if (isCycleDFS(0, -1, visited, adj)) {
            return false; // Cycle detected
        }

        // Check if all nodes are connected (single connected component)
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false; // Graph is not fully connected
            }
        }

        return true; // Valid tree
    }
}
