class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return solve(x,N);
    }
    public double solve(double x,long N){
        if(N==0) return 1;
        if(N%2==0){
            return solve(x*x,N/2);
        }
        else{
            return x*solve(x,N-1);
        }
    }
}