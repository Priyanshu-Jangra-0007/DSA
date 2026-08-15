public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.Length;i++){
            for(int j=i+1;j<nums.Length;j++){
                sum+=nums[i]+nums[j];
                if(sum==target) return new int[]{i,j};
                else sum=0;
            }
        }
        return new int[]{-1,-1};
    }
}