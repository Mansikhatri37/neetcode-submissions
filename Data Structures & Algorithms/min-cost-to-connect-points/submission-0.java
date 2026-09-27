
class Solution {
    
    public int minMST(List<List<int[]>> adj, int V) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // minheap
        pq.add(new int[]{0, 0}); // {weight, vertex}

        boolean[] inMST = new boolean[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int wt = p[0];
            int node = p[1];

            if (inMST[node]) continue;

            inMST[node] = true; // added to mst
            sum += wt;

            for (int[] tmp : adj.get(node)) {
                int neighbor = tmp[0];
                int neighbor_wt = tmp[1];

                if (!inMST[neighbor]) {
                    pq.add(new int[]{neighbor_wt, neighbor});
                }
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[]{j, d});
                adj.get(j).add(new int[]{i, d});
            }
        }

        return minMST(adj, V);
    }
}