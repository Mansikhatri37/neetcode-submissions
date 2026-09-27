class Solution {
    public boolean hasCycle = false;

    public void DFS(List<List<Integer>> adj, int u, boolean[] visited, Stack<Integer> st, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {
            if (inRecursion[v]) {
                hasCycle = true;
                return;
            }

            if (!visited[v]) {
                DFS(adj, v, visited, st, inRecursion);
                if (hasCycle) return; // early exit if a cycle is detected
            }
        }

        st.push(u);
        inRecursion[u] = false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int[] vec : prerequisites) {
            int a = vec[0];
            int b = vec[1];
            adj.get(b).add(a); // b --> a
        }

        // Create visited and recursion stack arrays
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        hasCycle = false;

        // Perform DFS on each node
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                DFS(adj, i, visited, st, inRecursion);
                if (hasCycle) return new int[0]; // If a cycle is detected, return an empty array
            }
        }

        // If no cycle, return the topological sort order
        int[] result = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()) {
            result[index++] = st.pop();
        }
        return result;
    }
}