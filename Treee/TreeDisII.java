// package Treee;
import java.io.*;
import java.util.*;
public class TreeDisII{
    static ArrayList<Integer>[] tree;
    static long[] distance;
    static int[] subTree;
    static long[] ans;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        N = n;
        tree = new ArrayList[n];
        distance = new long[n];
        subTree = new int[n];
        ans = new long[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0, -1);
        ans[0] = distance[0];
        reroot(0, -1);
        StringBuilder sb = new StringBuilder();
        for (long x : ans) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
    static void dfs(int node, int parent) {
        subTree[node] = 1;
        for (int child : tree[node]) {
            if (child == parent) continue;
            dfs(child, node);
            subTree[node] += subTree[child];
            distance[node] += distance[child] + subTree[child];
        }
    }
    static void reroot(int node, int parent) {
        for (int child : tree[node]) {
            if (child == parent) continue;
            ans[child] = ans[node] + N - 2 * subTree[child];
            reroot(child, node);
        }
    }
}