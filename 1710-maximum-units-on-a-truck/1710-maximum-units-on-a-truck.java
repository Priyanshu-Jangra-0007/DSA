class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int n=boxTypes.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int boxtake=Math.min(truckSize,boxTypes[i][0]);
            ans+=boxtake*boxTypes[i][1];
            truckSize-=boxtake;
            if(truckSize==0){
                break;
            }
        }
        return ans;
    }
}