class Solution {
    public int findGCD(int[] nums) {
        int maxval=Integer.MIN_VALUE;
        int minval=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            maxval=Math.max(maxval,nums[i]);
            minval=Math.min(minval,nums[i]);
        }
        return gcd(minval,maxval);
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}