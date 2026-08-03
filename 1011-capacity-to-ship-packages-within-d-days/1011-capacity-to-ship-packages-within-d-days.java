class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low =0;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int arr[],int maxcap,int totaldays){
        int day=1;
        int cap=0;
        for(int i=0;i<arr.length;i++){
            cap+=arr[i];
            if(cap>maxcap){
                cap=arr[i];
                day++;
            }
            if(day>totaldays) return false;
        }
        return true;
    }
}