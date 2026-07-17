class Solution {
    public double myPow(double x, int n) {
        long N=n;
        double ans=1;
        if(n<0){
            N=-N;
            x=1/x;
        }
        while(N>0){
            if(N%2==1){
                ans=ans*x;
            }
            x*=x;
            N/=2;
        }
    return ans;
    }
}