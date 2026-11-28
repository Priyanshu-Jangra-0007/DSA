class Solution {
    static int[] dp;
    public int fib(int n) {
        dp=new int[n+1];
        return solve(n);
    }
    public static int solve(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]!=0) return dp[n]; 
        return dp[n]=solve(n-1)+solve(n-2);
    }
}