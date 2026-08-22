class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int m=n;
        while(n>0){
            sum+=n%10;
            prod*=n%10;
            n=n/10;
        }
        return m%(sum+prod)==0;
    }
}