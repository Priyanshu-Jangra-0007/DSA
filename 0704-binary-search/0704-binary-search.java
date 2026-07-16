class Solution {
    public int search(int[] nums, int target) {
        return solve(nums,target,0,nums.length-1);
    }
    public int solve(int []nums,int target,int i,int j){
        if(i>j) return -1;
        int mid=i+(j-i)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]>target){
            return solve(nums,target,i,mid-1);
        }
        else{
            return solve(nums,target,mid+1,j);
        }
    }
}