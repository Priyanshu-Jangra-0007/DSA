class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low=1;
        int high=0;
        int ans=-1;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean possible(int arr[],int mid,int h){
        int hrs=0;
        for(int i=0;i<arr.length;i++){
            hrs+=arr[i]/mid;
            if(arr[i]%mid!=0){
                hrs++;
            }
            if(hrs>h) return false;
        }
        return true;
    }
}