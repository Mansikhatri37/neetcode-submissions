

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list for the graph
        List<List<int[]>> adj = new ArrayList<>();
        
        // Initialize the adjacency list
        for (int i = 0; i <= n; i++) { // Using `n+1` to simplify 1-based indexing
            adj.add(new ArrayList<>());
        }

        // Populate the graph with the times array
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int weight = time[2];
            adj.get(u).add(new int[]{v, weight});
        }

        // Distance array initialized to infinity
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // Distance to the source is 0

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Start with the source node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue; // Skip if we already have a shorter distance

            for (int[] next : adj.get(u)) {
                int v = next[0];
                int weight = next[1];

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // Find the maximum time to reach any node
        int maxTime = 0;
        for (int i = 1; i <= n; i++) { // Nodes are 1-indexed
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
