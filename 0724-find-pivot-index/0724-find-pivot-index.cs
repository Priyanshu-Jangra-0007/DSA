public class Solution {
    public int PivotIndex(int[] nums) {
        int leftsum=0;
        int totalsum=0;
        for(int i=0;i<nums.Length;i++){
            totalsum+=nums[i];
        }
        for(int i=0;i<nums.Length;i++){
            totalsum-=nums[i];
            if(leftsum==totalsum) return i;
            leftsum+=nums[i];
        }
        return -1;
    }
}