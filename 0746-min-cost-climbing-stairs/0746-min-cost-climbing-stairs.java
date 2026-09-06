class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        Integer dp[]=new Integer[n+1];
        return solve(cost,n,dp);
    }
    public static int solve(int arr[],int n,Integer dp[]){
        if(n<=0) return 0;
        if(dp[n]!=null) return dp[n];
        int left=solve(arr,n-1,dp)+arr[n-1];
        int right=0;
        if(n>1){
            right=solve(arr,n-2,dp)+arr[n-2];
        }
        return dp[n]=Math.min(left,right);
    }
}