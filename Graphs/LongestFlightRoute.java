import java.io.*;
import java.util.*;

// public class LongestFlightRoute {

//     static final long NEG_INF = Long.MIN_VALUE / 2;

//     public static void main(String[] args) throws Exception {

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        // List<List<Integer>> graph = new ArrayList<>();
        // for (int i = 0; i <= n; i++) {
        //     graph.add(new ArrayList<>());
        // }

        // int[] indeg = new int[n + 1];

        // for (int i = 0; i < m; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     int a = Integer.parseInt(st.nextToken());
        //     int b = Integer.parseInt(st.nextToken());
        //     graph.get(a).add(b);
        //     indeg[b]++;
        // }

//         // Topological Sort (Kahn's Algorithm)
//         Queue<Integer> q = new ArrayDeque<>();
//         for (int i = 1; i <= n; i++) {
//             if (indeg[i] == 0) {
//                 q.add(i);
//             }
//         }

//         List<Integer> topo = new ArrayList<>();
//         while (!q.isEmpty()) {
//             int u = q.poll();
//             topo.add(u);
//             for (int v : graph.get(u)) {
//                 indeg[v]--;
//                 if (indeg[v] == 0) {
//                     q.add(v);
//                 }
//             }
//         }

//         long[] dp = new long[n + 1];
//         int[] parent = new int[n + 1];
//         Arrays.fill(dp, NEG_INF);

//         dp[1] = 1; // starting city

//         for (int u : topo) {
//             if (dp[u] == NEG_INF) continue;
//             for (int v : graph.get(u)) {
//                 if (dp[v] < dp[u] + 1) {
//                     dp[v] = dp[u] + 1;
//                     parent[v] = u;
//                 }
//             }
//         }

//         if (dp[n] == NEG_INF) {
//             System.out.println("IMPOSSIBLE");
//             return;
//         }

//         // Reconstruct path
//         List<Integer> path = new ArrayList<>();
//         int cur = n;
//         while (cur != 0) {
//             path.add(cur);
//             cur = parent[cur];
//         }
//         Collections.reverse(path);

//         StringBuilder sb = new StringBuilder();
//         sb.append(path.size()).append('\n');
//         for (int x : path) {
//             sb.append(x).append(' ');
//         }

//         System.out.print(sb.toString());
//     }
// }

public class LongestFlightRoute{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        int[] parent =new int[n + 1];
        Arrays.fill(parent,-1);
        int[] countcities =new int[n + 1];
        countcities[1]=1;
        int[] indeg =new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        //topo sort
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:adj.get(u)){
                if(countcities[u]>0 && countcities[u]+1>countcities[v]){
                    countcities[v]=countcities[u]+1;
                    parent[v]=u;
                }
                indeg[v]--;
                if(indeg[v]==0){
                    q.offer(v);
                }
            }
        }
        if(countcities[n]==0 ){
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> path=new ArrayList<>();
        for(int curr=n;curr!=-1;curr=parent[curr]){
            path.add(curr);
        }
        Collections.reverse(path);
        int pathl=path.size();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pathl+"\n");
        for(int val:path){
            bw.write(val+" ");
        }
        bw.flush();
    }
}