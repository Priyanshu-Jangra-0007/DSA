class Solution {
    static Integer dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new Integer[n+1];
        if(n==1) return nums[0];
        int profit1=solve(nums,0,n-2);
        dp=new Integer[n+1];
        int profit2=solve(nums,1,n-1);
        return Math.max(profit1,profit2);
    }
    public static int solve(int nums[],int st,int n){
        if(st>n) return 0;
        if(dp[st]!=null) return dp[st];
        int left=solve(nums,st+2,n)+nums[st];
        int right=solve(nums,st+1,n);
        return dp[st]=Math.max(left,right);
    }
}