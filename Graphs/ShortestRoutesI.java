import java.io.*;
import java.util.*;
public class ShortestRoutesI {
    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            adj.get(a).add(new Pair(b, c));
        }
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair> pq =new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        dist[1] = 0;
        pq.offer(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            if (curr.dist > dist[u]) continue;
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                long weight = neighbor.dist;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }
}
