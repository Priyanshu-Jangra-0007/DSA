class Solution {
    static Integer dp[][];
    public int change(int amount, int[] coins) {
        dp=new Integer[amount+1][coins.length+1];
        return solve(coins,amount,0);
    }
    public static int solve(int arr[],int W,int i){
        int n=arr.length;
        if(W==0) return 1;
        if(i>=n) return 0;
        if(dp[W][i]!=null) return dp[W][i];
        int np=solve(arr,W,i+1);
        int pick=0;
        if(arr[i]<=W){
            pick=solve(arr,W-arr[i],i);
        }
        return dp[W][i]=pick+np;
    }
}