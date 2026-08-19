class Solution {
    public int jump(int[] nums) {
        Integer dp[]=new Integer[nums.length+1];
        return solve(nums,0,dp);
    }
    public static int solve(int[] nums,int i,Integer dp[]){
        int n=nums.length;
        if(i>=n-1) return 0;
        if(dp[i]!=null) return dp[i];
        int minjump=(int) 1e9;
        for(int j=1;j<=nums[i];j++){
            int jump=1+solve(nums,i+j,dp);
            minjump=Math.min(minjump,jump);
        }
        return dp[i]=minjump;
    }
}