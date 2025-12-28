public class PerfectSum {
    public static int perfectSum(int[] nums, int target) {
        int n=nums.length;
        Integer dp[][]=new Integer[n+1][target+1];
        return solve(nums,target,n,dp);
    }

    public static int solve(int nums[],int target,int n,Integer dp[][]){
        if(n==0) {
            if(target==0) return 1;
            else return 0;
        }
        if(dp[n][target]!=null) return dp[n][target];
        //Not Pick
        int not_pick=solve(nums,target,n-1,dp);
        //Pick
        int pick=0;
        if(nums[n-1]<=target){
            pick=solve(nums,target-nums[n-1],n-1,dp);
        }
        dp[n][target]=pick+not_pick;
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10};
        int target = 10;
        System.out.println(perfectSum(nums, target));
    }
}
