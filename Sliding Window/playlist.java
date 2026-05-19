import java.io.*;
import java.util.*;
public class playlist{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        HashSet<Integer> set=new HashSet<>();
        int left=0,maxLen=0;
        for(int right=0;right<n;right++){
            while(set.contains(arr[right])){
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            maxLen=Math.max(maxLen,right-left+1);
        }
        System.out.println(maxLen);
    }
}