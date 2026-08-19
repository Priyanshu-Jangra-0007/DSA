class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        int n=nums.length;
        for(int x:nums){
            max=Math.max(max,x);
        }
        int arr[]=new int[max+1];
        for(int i=0;i<n;i++){
            arr[nums[i]]+=nums[i];
        }
        Integer dp[]=new Integer[max+1];
        return solve(arr,max,dp);
    }
    public static int solve(int arr[],int n,Integer dp[]){
        if(n<0) return 0;
        if(dp[n]!=null) return dp[n];
        int pick=solve(arr,n-2,dp)+arr[n];
        int skip=solve(arr,n-1,dp);
        return dp[n]=Math.max(pick,skip);
    }
}