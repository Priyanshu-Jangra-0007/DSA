class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(cost,n,dp);
    }
    public static int solve(int arr[],int n,int dp[]){
        if(n<=1) return 0;
        if(dp[n]!=-1) return dp[n];
        int left=solve(arr,n-1,dp)+arr[n-1];
        int right=(int) 1e9;
        if(n>1){
            right=solve(arr,n-2,dp)+arr[n-2];
        }
        return dp[n]= Math.min(left,right);
    }
}