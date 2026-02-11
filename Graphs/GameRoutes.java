import java.util.*;
import java.io.*;

public class GameRoutes {
   static final int MOD = 1000000007;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());// reads 1st line and take input

      int n = Integer.parseInt(st.nextToken());// parsing bcz it st.nextToken returns string and we need int
      int m = Integer.parseInt(st.nextToken());

      int[] indeg = new int[n + 1];

      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
         adj.add(new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine());
         int u = Integer.parseInt(st.nextToken());
         int v = Integer.parseInt(st.nextToken());
         adj.get(u).add(v);
         indeg[v]++;
      }

      int[] ways = new int[n + 1];
      ways[1] = 1;

      Queue<Integer> q = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
         if (indeg[i] == 0) {
            q.offer(i);
         }
      }

      while (!q.isEmpty()) {
         int u = q.poll();

         for (int v : adj.get(u)) {
            if (ways[u] > 0 && ways[u] + ways[v] > ways[v]) { // this ensure we start from city 1
               ways[v] = (ways[u] + ways[v]) % MOD;
            }
            indeg[v]--;
            if (indeg[v] == 0) {
               q.offer(v);
            }
         }
      }
      System.out.println(ways[n]);
   }
}