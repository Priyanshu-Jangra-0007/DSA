import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class hotelQuerries {
    static int st[];
    public static void buildtree(int idx,int l,int r,int arr[]){
        if(l==r){
            st[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildtree(2*idx+1, l, mid, arr);
        buildtree(2*idx+2, mid+1, r, arr);
        st[idx]=Math.max(st[2*idx+1],st[2*idx+2]);
    }
    public static long hotelsearch(int idx,int left,int right,int target,int arr[]){
        if(st[idx]<target) return -1;
        if(left==right){
            arr[left]-=target;
            st[idx]-=target;
            return left;
        }
        int mid=left+(right-left)/2;
        long ans;
        if(st[2*idx+1]>=target){
            ans=hotelsearch(2*idx+1, left, mid, target, arr);
        }
        else{
            ans=hotelsearch(2*idx+2, mid+1, right, target, arr);
        }
        st[idx]=Math.max(st[2*idx+1],st[2*idx+2]);
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(stt.nextToken());
        int m=Integer.parseInt(stt.nextToken());
        int h[]=new int[n];
        int r[]=new int[m];
        stt=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            h[i]=Integer.parseInt(stt.nextToken());
        }
        stt=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            r[i]=Integer.parseInt(stt.nextToken());
        }
        st=new int[4*n];
        buildtree(0, 0, n-1, h);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            long res=hotelsearch(0, 0, n-1, r[i], h);
            if(res==-1){
                sb.append(0).append(" ");
            }
            else{
                sb.append(res+1).append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}