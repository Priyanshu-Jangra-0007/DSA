class Solution {
    static Integer dp[][];
    public int coinChange(int[] coins, int amount) {
        dp=new Integer[coins.length+1][amount+1];
        int ans=solve(coins,amount,0);
        return ans==(int) 1e9?-1:ans;
    }
    public static int solve(int arr[],int W,int i){
        int n=arr.length;
        if(W==0) return 0;
        if(i>=n) return (int) 1e9;
        if(dp[i][W]!=null) return dp[i][W];
        int np=solve(arr,W,i+1);
        int pick=(int) 1e9;
        if(arr[i]<=W){
            pick=1+solve(arr,W-arr[i],i);
        }
        return dp[i][W]=Math.min(pick,np);
    }
}