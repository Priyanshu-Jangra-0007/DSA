class Solution {
    public int maxProfit(int[] prices) {
        int minval=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            minval=Math.min(minval,prices[i]);
            profit=Math.max(profit,prices[i]-minval);
        }
        return profit;
    }
}