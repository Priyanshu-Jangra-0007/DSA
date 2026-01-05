// import java.util.*;
// //----------------------------------------recursion------------------------------------------
// public class Counting_NO{
//     public static void main(String args[]){
//         Scanner sc =new Scanner (System.in);
//         long a,b;
//         a=sc.nextLong();
//         b=sc.nextLong();
//         String l=String.valueOf(a-1);
//         String r=String.valueOf(b);
//         long ans=solve(r,0,1,10,1)-solve(l,0,1,10,1);
//         System.out.println(ans);
//     }
//     public static long solve(String s,int idx,int tight,int prev,int lz){
//         if(idx==s.length()) return 1;
//         int lb=0;
//         int ub=(tight==1) ?s.charAt(idx)-'0':9;
//         long res=0;
//         for(int digit=lb;digit<=ub;digit++){
//             if(lz==0 && digit==prev) continue ;
//             int newTight=(tight==1 && digit==ub) ?1:0;
//             int newlz=(lz==1 && digit==0)?1:0;
//             res+=solve(s, idx+1, newTight, digit, newlz);
//         }
//         return res;
//     }
// }
import java.util.*;
//----------------------------------------MEMOIZATION------------------------------------------
public class Counting_NO{
    public static void main(String args[]){
        Scanner sc =new Scanner (System.in);
        long a,b;
        a=sc.nextLong();
        b=sc.nextLong();
        String l=String.valueOf(a-1);
        String r=String.valueOf(b);
        Long [][][][] dp1=new Long[20][2][11][2];
        Long [][][][] dp2=new Long[20][2][11][2];
        long ans=solve(r,0,1,10,1,dp2)-solve(l,0,1,10,1,dp1);
        System.out.println(ans);
    }

    public static long solve(String s,int idx,int tight,int prev,int lz,Long [][][][]dp){
        if(idx==s.length()) return 1;

        if(dp[idx][tight][prev][lz] != null)
            return dp[idx][tight][prev][lz];

        int lb=0;
        int ub=(tight==1) ?s.charAt(idx)-'0':9;
        long res=0;
        for(int digit=lb;digit<=ub;digit++){
            if(lz==0 && digit==prev) continue ;
            int newTight=(tight==1 && digit==ub) ?1:0;
            int newlz=(lz==1 && digit==0)?1:0;
            res+=solve(s, idx+1, newTight, digit, newlz,dp);
        }
        return dp[idx][tight][prev][lz]=res;
    }
}
