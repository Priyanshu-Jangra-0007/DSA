class Solution {
    public int tribonacci(int n) {
        Integer dp[]=new Integer[n+1];
        return solve(n,dp);
    }
    public static int solve(int n,Integer dp[]){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n]!=null) return dp[n];
        return dp[n]=solve(n-1,dp)+solve(n-2,dp)+solve(n-3,dp);
    }
}