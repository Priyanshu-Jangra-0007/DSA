class Solution {
    static Integer dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        dp=new Integer[n+1];
        int left=solve(nums,n-2,0);
        dp=new Integer[n+1];
        int right=solve(nums,n-1,1);
        return Math.max(left,right);
    }
    public static int solve(int arr[],int n,int st){
        if(n<st) return 0;
        if(dp[n]!=null) return dp[n];
        int pick=solve(arr,n-2,st)+arr[n];
        int skip=solve(arr,n-1,st);
        return dp[n]=Math.max(pick,skip);
    }
}