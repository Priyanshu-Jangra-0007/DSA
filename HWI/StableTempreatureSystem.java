import java.util.Arrays;
public class StableTempreatureSystem {
    public static void main(String[] args) {
        int[] arr = {4,9,3,2,7};
        // int[] arr = {10,8,6,4};
        // int[] arr = {0,100,0,100,0};
        // int[] arr = {1,3,5,7,9};
        int n = arr.length;
        int points = 0;
        for(int i=n-1; i>0; i--){
            if(Math.abs(arr[i]-arr[i-1]) > 1){
                if(arr[i] > arr[i-1]){
                    points += Math.abs(arr[i] - arr[i-1])-1;
                    arr[i] = arr[i-1]+1;
                    System.out.println(i + " " + points);
                }else{
                    points += Math.abs(arr[i-1] - arr[i])-1;
                    arr[i-1] = arr[i]+1;
                    System.out.println(i + " " + points);
                }
                System.out.println("entered");
            }
        }

        for(int i=0; i<n-1; i++){
            if(Math.abs(arr[i]-arr[i+1]) > 1){
                if(arr[i] > arr[i+1]){
                    points += (arr[i] - arr[i+1])-1;
                    arr[i] = arr[i+1]+1;
                    System.out.println(i + " " + points);
                }else{
                    points += (arr[i+1] - arr[i])-1;
                    arr[i+1] = arr[i]+1;
                    System.out.println(i + " " + points);
                }
            }
        }
        
        System.out.println(Arrays.toString(arr));
        System.out.println(points);
    }
}