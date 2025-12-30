package Recursion;
public class TowerOfHanoi {
    public static void TOH(int n,String Src,String Helper,String Dest){
        if(n==1){
            System.out.println("Transfer disc " +n+"from "+Src+" to "+Dest);
            return;
        }
        TOH(n-1,Src,Dest,Helper);
        System.out.println("Transfer disc " +n+"from "+Src+" to "+Helper);
        TOH(n-1,Helper,Src,Dest);
        System.out.println("Transfer disc " +n+"from "+Helper+" to "+Dest);
    }
    public static void main(String args[]){
        int n=3;
        TOH(n,"Source","Helper","Destination");
    }
}
