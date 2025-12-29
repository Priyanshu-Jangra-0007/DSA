public class knapsack {
    // public static int knapsack(int wt[],int val[],int W,int n){
    //     if(n==0 || W==0) return 0;
    //     //NOT_PICK
    //     int not_pick=knapsack(wt, val, W, n-1);
    //     //PICK
    //     int pick=0;
    //     if(wt[n-1]<=W){
    //         pick=val[n-1]+knapsack(wt, val, W-wt[n-1], n-1);
    //     }
    //     return Math.max(pick,not_pick);
    // }
    public static int knapsack(int wt[],int val[],int W,int n,Integer dp[][]){
        if(n==0 || W==0) return 0;
        if(dp[n][W] !=null) return dp[n][W];
        //NOT_PICK
        int not_pick=knapsack(wt, val, W, n-1,dp);
        //PICK
        int pick=0;
        if(wt[n-1]<=W){
            pick=val[n-1]+knapsack(wt, val, W-wt[n-1], n-1,dp);
        }
        dp[n][W]=Math.max(pick,not_pick);
        return dp[n][W];
    }
    public static void main(String[] args) {
        int wt[]={1,2,3,4,5};
        int val[]={5,4,3,2,1};
        int W=4;
        int n=wt.length;
        Integer dp[][]=new Integer[n+1][W+1];
        System.out.println(knapsack(wt, val, W, n,dp));
    }
}
