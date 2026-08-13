class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=-(int) 1e9;
        for(int x:nums){
            high=Math.max(high,x);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(ispossible(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean ispossible(int arr[],int mid,int t){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]%mid==0){
                sum+=arr[i]/mid;
            }
            else{
                sum+=arr[i]/mid+1;
            }
            if(sum>t){
                return false;
            }
        }
        return true;
    }
}