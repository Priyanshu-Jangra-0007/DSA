class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[]=new int[n+1];
        int minval=prices[0];
        for(int i=1;i<prices.length;i++){
            minval=Math.min(minval,prices[i]);
            dp[i]=Math.max(dp[i-1],prices[i]-minval);
        }
        return dp[n-1];
    }
}