// package Tree;
import java.io.*;
import java.util.*;
public class TreePainting {
    static ArrayList<Integer>[] tree;
    static long[] ans;
    static int[] subTree;
    static int N;
    static long initialScore = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        N = n;
        tree = new ArrayList[n];
        subTree = new int[n];
        ans = new long[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0,-1);
        ans[0] = initialScore;
        reroot(0,-1);
        long result = 0;
        for(long x : ans){
            result = Math.max(result,x);
        }
        System.out.println(result);
    }
    static void dfs(int node,int parent){
        subTree[node] = 1;
        for(int child : tree[node]){
            if(child == parent) continue;
            dfs(child,node);
            subTree[node] += subTree[child];
        }
        initialScore += subTree[node];
    }
    static void reroot(int node,int parent){
        for(int child : tree[node]){
            if(child == parent) continue;
            ans[child] = ans[node] + N - 2L * subTree[child];
            reroot(child,node);
        }
    }
}