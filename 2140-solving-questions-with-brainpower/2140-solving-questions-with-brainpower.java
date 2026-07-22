class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long dp[]=new long[n+1];
        Arrays.fill(dp,0);
        return solve(questions,0,dp);
    }
    public static long solve(int arr[][],int i,long dp[]){
        int n=arr.length;
        if(i>=n) return 0;
        if(dp[i]!=0) return dp[i];
        long take =arr[i][0]+solve(arr,i+arr[i][1]+1,dp);
        long skip=0+solve(arr,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }
}