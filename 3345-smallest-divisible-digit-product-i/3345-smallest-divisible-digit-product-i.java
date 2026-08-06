class Solution {
    public int smallestNumber(int n, int t) {
        int ans = 0;
        for(int i = n ; i<= 100; i++){
            int prod = 1;
            int temp = i;
            while(temp>0){
                int mod = temp%10;
                prod*=mod;
                temp/=10;
            }
            System.out.println(prod);
            if(prod%t==0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}