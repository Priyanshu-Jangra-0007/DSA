class Solution {
    static Integer dp[];
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int max=-(int) 1e9;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        int n=max+1;
        dp=new Integer[n+1];
        int arr[]=new int[n];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=nums[i];
        }
        return solve(arr,n-1);
    }
    public static int solve(int arr[],int n){
        if(n<0) return 0;
        if(n==0) return arr[0];
        if(dp[n]!=null) return dp[n];
        int left=solve(arr,n-2)+arr[n];
        int right=solve(arr,n-1);
        return dp[n]=Math.max(left,right);
    }
}