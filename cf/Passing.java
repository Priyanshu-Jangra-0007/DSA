package cf;

import java.util.Scanner;

public class Passing{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            int n=sc.nextInt();
            String s=sc.next();
            int count=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='L'){
                    break;
                }
                count++;
            }
            System.out.println(count+1);
        }
    }
}