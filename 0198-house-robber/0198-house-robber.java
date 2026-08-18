class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,n-1,dp);
    }
    public static int solve(int arr[],int n,int dp[]){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left=solve(arr,n-2,dp)+arr[n];
        int right=solve(arr,n-1,dp);
        return dp[n]=Math.max(left,right);
    }
}