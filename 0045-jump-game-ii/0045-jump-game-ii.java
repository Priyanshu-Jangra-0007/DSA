class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int end=0;
        int maxi=0;
        for(int i=0;i<nums.length-1;i++){
            maxi=Math.max(maxi,i+nums[i]);
            if(i==end){
                end=maxi;
                jump++;
            }
        }
        return jump;
    }
}