public class CountSubsetsSum {
    public static int countSubsets(int arr[],int n,int sum,Integer[][]dp){
        if(sum==0) return 1;
        if(n==0) return 0;
        if(dp[n][sum] !=null) return dp[n][sum];
        //Not Pick
        int not_pick=countSubsets(arr, n-1, sum,dp);
        // Pick
        int pick=0;
        if(arr[n-1]<=sum){
            pick=countSubsets(arr, n-1, sum-arr[n-1],dp);
        }
        dp[n][sum]=pick+not_pick;
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3};
        int sum = 6;
        int n = arr.length;
        Integer dp[][]=new Integer[n+1][sum+1];
        System.out.println(countSubsets(arr, n, sum,dp));
    }
}
