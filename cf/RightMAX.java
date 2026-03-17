package cf;

import java.util.Scanner;

public class RightMAX{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int max=0;
            int opr=0;
            for(int i=0;i<n;i++){
                if(arr[i]>=max){
                    opr++;
                    max=arr[i];
                }
            }
            System.out.println(opr);
        }
    }
}