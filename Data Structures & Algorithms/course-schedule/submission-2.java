
class Solution {

    public boolean topoLogicalSort(int numCourses, ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;

            for (int v : adj.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Using BFS (Kahn's Algorithm)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[] indegree = new int[numCourses];

        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] v : prerequisites) {
            int a = v[0];
            int b = v[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        // Perform topological sort
        return topoLogicalSort(numCourses, adj, indegree);
    }
}
