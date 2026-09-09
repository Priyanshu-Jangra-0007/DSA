class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        Boolean dp[]=new Boolean[n+1];
        return solve(nums,0,dp);
    }
    public boolean solve(int[] nums,int i,Boolean dp[]){
        if(i>=nums.length-1) return true;
        if(dp[i]!=null) return dp[i];
        for(int j=1;j<=nums[i];j++){
            if(solve(nums,i+j,dp)){
                return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
}