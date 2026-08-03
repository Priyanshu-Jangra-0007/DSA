class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=-(int)1e9;
        for(int i=0;i<n;i++){
            high=Math.max(high,piles[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int arr[],int eatingspeed,int maxhrs){
        int n=arr.length;
        int hrs=0;
        for(int i=0;i<n;i++){
            hrs+=arr[i]/eatingspeed;
            if(arr[i]%eatingspeed!=0){
                hrs++;
            }
            if(hrs>maxhrs) return false;
        }
        return true;
    }
}