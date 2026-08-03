class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        int low=-(int)1e9;
        int high=0;
        for(int i=0;i<n;i++){
            high+=nums[i];
            low=Math.max(nums[i],low);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int []nums,int maxsum,int k){
        int sum=0;
        int cnt=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>maxsum){
                sum=nums[i];
                cnt++;
            }
            if(cnt>k) return false;
        }
        return true;
    }
}