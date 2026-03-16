import java.io.*;
import java.util.*;
public class StaticRangeQuery{
    static long[] pref;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        pref=new long[n];
        long[] nums=new long[n];
        StringTokenizer st2=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(st2.nextToken());
        }
        prefsuff(nums);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter (System.out));
        for(int i=0;i<q;i++){
            StringTokenizer st3=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st3.nextToken())-1;
            int b=Integer.parseInt(st3.nextToken())-1;
            if(a==0)
            bw.write(pref[b]+"\n");
            else
            bw.write(pref[b]-pref[a-1]+"\n");
        }
        bw.flush();
    }
    public static void prefsuff(long[] nums){
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i]=pref[i-1]+nums[i];
        }
    }
}