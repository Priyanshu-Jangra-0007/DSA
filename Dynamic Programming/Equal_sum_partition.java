//---------------   RECURSION   ---------------
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             sum += nums[i];
//         }
//         if (sum % 2 != 0) return false;
//         else return solve(nums, sum / 2, n);
//     }
//
//     public boolean solve(int nums[], int sum, int n) {
//         if (sum == 0) return true;
//         if (n == 0) return false;
//
//         boolean not_pick = solve(nums, sum, n - 1);
//         boolean pick = false;
//         if (nums[n - 1] <= sum) {
//             pick = solve(nums, sum - nums[n - 1], n - 1);
//         }
//         return pick || not_pick;
//     }
// }

//-------------------- MEMOIZATION -----------------
public class Equal_sum_partition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;

        Boolean dp[][] = new Boolean[n + 1][sum + 1];
        return solve(nums, sum / 2, n, dp);
    }

    public boolean solve(int nums[], int sum, int n, Boolean dp[][]) {
        if (sum == 0) return true;
        if (n == 0) return false;

        if (dp[n][sum] != null) return dp[n][sum];

        boolean not_pick = solve(nums, sum, n - 1, dp);
        boolean pick = false;

        if (nums[n - 1] <= sum) {
            pick = solve(nums, sum - nums[n - 1], n - 1, dp);
        }

        dp[n][sum] = pick || not_pick;
        return dp[n][sum];
    }
    public static void main(String[] args) {
        Equal_sum_partition obj = new Equal_sum_partition();

        int[] nums = {1, 5, 11, 5};

        boolean result = obj.canPartition(nums);

        if (result) {
            System.out.println("Equal Sum Partition Possible");
        } else {
            System.out.println("Equal Sum Partition NOT Possible");
        }
    }
}
