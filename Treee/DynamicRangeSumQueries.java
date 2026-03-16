import java.io.*;
import java.util.*;
public class DynamicRangeSumQueries{
    static long seg[];
    public void buildtree(int idx,int l,int r,long arr[]){
        if(l==r){
            seg[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildtree(2*idx+1, l, mid, arr);
        buildtree(2*idx+2, mid+1, r, arr);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public void update(int idx,int i,long val,int l,int r){
        if(l==r){
            seg[idx]=val;
            return;
        }
        int mid=(l+r)/2;
        if(i<=mid){
            update(2*idx+1, i, val, l, mid);
        }
        else{
            update(2*idx+2, i, val, mid+1, r);
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public static long querysum(int idx, int L, int R, int qs, int qe) {
        if (R < qs || L > qe)
            return 0L;
        if (qs <= L && R <= qe)
            return seg[idx];
        int mid = L + (R - L) / 2;
        long left = querysum(2 * idx + 1, L, mid, qs, qe);
        long right = querysum(2 * idx + 2, mid + 1, R, qs, qe);
        return left + right;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        long arr[]=new long[n];
        seg=new long[4*n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        DynamicRangeSumQueries obj=new DynamicRangeSumQueries();
        obj.buildtree(0,0,n-1,arr);
        StringBuilder ans=new StringBuilder();
        while(q-->0){
            st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            if(type==1){
                int k=Integer.parseInt(st.nextToken())-1;
                long u=Long.parseLong(st.nextToken());
                obj.update(0,k,u,0,n-1);
            }
            else{
                int a=Integer.parseInt(st.nextToken())-1;
                int b=Integer.parseInt(st.nextToken())-1;
                ans.append(querysum(0,0,n-1,a,b)).append("\n");
            }
        }
        System.out.print(ans);
    }
}