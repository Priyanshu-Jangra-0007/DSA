import java.util.*;
import java.io.*;
public class LCABoilerplate {
    static int N=200005;
    static int log=20;
    static int [][] up=new int [N][log];
    static int [] depth=new int [N];
    static ArrayList<Integer> [] tree=new ArrayList [N];

    public static void dfs(int node,int parent){
        up[node][0]=parent;
        for(int i=1;i<log;i++){
            if(up[node][i-1]!=-1){
                up[node][i]=up[up[node][i-1]][i-1];
            }
        }
        for(int child : tree[node]){
            if(child!=parent){
                depth[child]=depth[node]+1;
                dfs(child,node);
            }
        }
    }
    public static int lift(int node,int k){
        for(int i=log-1;i>=0;i--){
            if((k & (1<<i))!=0){
                node=up[node][i];
                if(node==-1) return -1;
            }
        }
        return node;
    }
    public static int lca(int a,int b){
        if(depth[a]<depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }
        int diff=depth[a]-depth[b];
        a=lift(a,diff);
        if(a==b) return a;
        for(int i=log-1;i>=0;i--){
            if(up[a][i]!=up[b][i]){
                a=up[a][i];
                b=up[b][i];
            }
        }
        return up[a][0];
    }
    public static int distance(int a,int b){
        return depth[a]+depth[b]-2*depth[lca(a,b)];
    }
    public int kthnodeinpath(int a,int b,int k){
        int l=lca(a,b);
        int d1=depth[a]-depth[l];
        if(k<=d1+1) return lift(a,k-1);
        int d2=depth[b]-depth[l];
        int remNodes=d1+d2-(k-1);
        return lift(b,remNodes);
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            Arrays.fill(up[i],-1);
        }
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0,-1);
    }

}
