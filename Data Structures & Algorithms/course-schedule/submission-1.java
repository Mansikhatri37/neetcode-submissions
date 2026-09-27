
class Solution {

    public boolean isCycleDFS(int i, boolean[] visited, boolean[] inRecursion, HashMap<Integer, List<Integer>> map) {
        // Mark as visited
        visited[i] = true;

        // Mark inRecursion
        inRecursion[i] = true;

        // Explore neighbors
        for (int v : map.get(i)) {
            if (!visited[v] && isCycleDFS(v, visited, inRecursion, map)) {
                return true; // Cycle detected
            } else if (inRecursion[v]) {
                return true; // Cycle detected due to back edge
            }
        }

        // Remove from recursion stack
        inRecursion[i] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Detection of cycle in directed graph

        // 1. Create a graph
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // 2. Add edges to the graph
        for (int[] list : prerequisites) {
            int u = list[0];
            int v = list[1];
            map.get(v).add(u); // Directed edge from v to u
        }

        // 3. Create visited and inRecursion arrays
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        // 4. Start DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCycleDFS(i, visited, inRecursion, map)) {
                return false; // Cycle detected, cannot finish courses
            }
        }

        return true; // No cycle detected, can finish courses
    }
}
