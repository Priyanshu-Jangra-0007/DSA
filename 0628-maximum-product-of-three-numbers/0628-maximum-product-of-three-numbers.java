class Solution {
    public int maximumProduct(int[] nums) {
        int n =nums.length;
        Arrays.sort(nums);
        int min1=nums[0];
        int min2=nums[1];
        int max1=nums[n-1];
        int max2=nums[n-2];
        int max3=nums[n-3];
        int prod1=min1*min2*max1;
        int prod2=max1*max2*max3;
        return Math.max(prod1,prod2);
    }
}