class Solution {
    public ArrayList<Integer> topoCheck(ArrayList<ArrayList<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            count++;

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        if (count == n) {
            return res;
        } else {
            return new ArrayList<>(); // return an empty list if there's a cycle
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize the adj list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Calculate the indegree of each element
        int[] indegree = new int[numCourses];

        for (int[] v : prerequisites) {
            int a = v[0];
            int b = v[1];

            // b -> a
            adj.get(b).add(a);
            indegree[a]++;
        }

        ArrayList<Integer> orderList = topoCheck(adj, numCourses, indegree);
        if (orderList.isEmpty()) {
            return new int[0];
        } else {
            int[] order = new int[orderList.size()];
            for (int i = 0; i < orderList.size(); i++) {
                order[i] = orderList.get(i);
            }
            return order;
        }
    }
}