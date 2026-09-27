class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        // Iterate over all pairs of days
        for (int i = 0; i < n; i++) { // Buy on day i
            for (int j = i + 1; j < n; j++) { // Sell on day j
                int profit = prices[j] - prices[i]; // Calculate profit
                maxProfit = Math.max(maxProfit, profit); // Update maxProfit if needed
            }
        }

        return maxProfit;
    }
}
