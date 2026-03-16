// package Treee;
import java.io.*;
import java.util.*;
public class TreeWithMaxCost {
    static List<Integer>[] tree;
    static long[] subtreeSum;
    static long[] dp;
    static long[] ans;
    static long[] a;
    static int n;
    static long totalSum = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        a = new long[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            totalSum += a[i];
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        subtreeSum = new long[n + 1];
        dp = new long[n + 1];
        ans = new long[n + 1];

        dfs(1, 0);

        ans[1] = dp[1];

        reroot(1, 0);

        long res = 0;

        for (int i = 1; i <= n; i++) {
            res = Math.max(res, ans[i]);
        }

        System.out.println(res);
    }

    static void dfs(int node, int parent) {

        subtreeSum[node] = a[node];

        for (int child : tree[node]) {

            if (child == parent) {
                continue;
            }

            dfs(child, node);

            subtreeSum[node] += subtreeSum[child];

            dp[node] += dp[child] + subtreeSum[child];
        }
    }

    static void reroot(int node, int parent) {

        for (int child : tree[node]) {

            if (child == parent) {
                continue;
            }

            ans[child] = ans[node] + totalSum - 2 * subtreeSum[child];

            reroot(child, node);
        }
    }
}