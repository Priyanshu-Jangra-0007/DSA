// public class Main {

//     public static boolean subset(int nums[], int target) {
//         int n = nums.length;
//         return solve(n, nums, target);
//     }

//     public static boolean solve(int n, int nums[], int target) {

//         // base cases
//         if (target == 0) return true;
//         if (n == 0) return false;

//         // not pick
//         boolean not_pick = solve(n - 1, nums, target);

//         // pick (only if allowed)
//         boolean pick = false;
//         if (nums[n - 1] <= target) {
//             pick = solve(n - 1, nums, target - nums[n - 1]);
//         }

//         return pick || not_pick;
//     }

//     public static void main(String[] args) {
//         int nums[] = {1, 2, 3, 4, 5};
//         boolean res = subset(nums, 3);

//         if (res) {
//             System.out.println("Subset found");
//         } else {
//             System.out.println("Not found");
//         }
//     }
// }

public class Subset_Sum{
    public static boolean subset(int nums[],int target){
        int n=nums.length;
        Boolean dp[][]=new Boolean[n+1][target+1];
        return solve(n,nums,target,dp);
    }
    public static boolean solve(int n,int nums[],int target,Boolean dp[][]){
        if(target==0) return true;
        if(n==0) return false;
        if(dp[n][target] != null) return dp[n][target];
        //not pick
        boolean not_pick=solve(n-1,nums,target,dp);
        boolean pick=false;
        if(nums[n-1]<=target){
            pick=solve(n-1, nums, target-nums[n-1],dp);
        }
        dp[n][target]=pick||not_pick;
        return dp[n][target];
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,4,5};
        boolean res=subset(nums,3);
        if(res){
            System.out.println("Subset found");
        }
        else{
            System.out.println("Not found");
        }
    }
}