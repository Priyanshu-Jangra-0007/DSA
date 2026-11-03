class Solution {
    public int minMoves(int[] nums) {
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(nums[i],maxi);
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            cnt+=maxi-nums[i];
        }
        return cnt;
    }
}