public class CountSubsetsSum {
    public static int countSubsets(int arr[],int n,int sum){
        if(sum==0) return 1;
        if(n==0) return 0;
        //Not Pick
        int not_pick=countSubsets(arr, n-1, sum);
        // Pick
        int pick=0;
        if(arr[n-1]<=sum){
            pick=countSubsets(arr, n-1, sum-arr[n-1]);
        }
        return pick+not_pick;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3};
        int sum = 6;
        int n = arr.length;

        System.out.println(countSubsets(arr, n, sum));
    }
}
