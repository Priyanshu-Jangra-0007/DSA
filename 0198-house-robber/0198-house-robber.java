class Solution {
    static Integer dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new Integer[n+1];
        return solve(nums,n-1);
    }
    public static int solve(int []nums,int n){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(dp[n]!=null) return dp[n];
        int left=solve(nums,n-2)+nums[n];
        int right=solve(nums,n-1);
        return dp[n]= Math.max(left,right);
    }
}