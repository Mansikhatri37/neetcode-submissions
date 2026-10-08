class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }

        int buy = 0 ; //buy day
        int sell = 1 ; //sell day

        int maxProfit = 0;

        while(sell < prices.length){

            if(prices[buy] < prices[sell]){
                int profit = prices[sell] - prices[buy];
                //profit
                maxProfit = Math.max(maxProfit,profit);
            }
            else{
                buy = sell;
            }
            sell++;
        }

        return maxProfit;

    }
}
