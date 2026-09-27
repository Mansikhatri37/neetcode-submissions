
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.get(u).add(new int[]{v, price});
        }

        // Priority queue to store {currentNode, stopsUsed, totalPrice}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{src, 0, 0}); // Start with source node, 0 stops, and 0 price

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int stops = curr[1];
            int price = curr[2];

            // If destination is reached, return the price
            if (node == dst) {
                return price;
            }

            // If stops exceed k, skip this path
            if (stops > k) {
                continue;
            }

            // Explore neighbors
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int nextPrice = neighbor[1];
                pq.add(new int[]{nextNode, stops + 1, price + nextPrice});
            }
        }

        return -1; // If no valid path is found
    }
}
