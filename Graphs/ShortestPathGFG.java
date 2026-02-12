import java.util.*;
public class ShortestPathGFG {
    public static int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int neighbor : adj.get(node)) {
                if(dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V1 = 9;
        int[][] edges1 = {
            {0,1},{0,3},{1,2},{3,4},{4,5},
            {2,6},{5,6},{6,7},{6,8},{7,8}
        };
        int src1 = 0;
        System.out.println(Arrays.toString(shortestPath(V1, edges1, src1)));

        int V2 = 4;
        int[][] edges2 = {
            {0,3},{1,3}
        };
        int src2 = 3;
        System.out.println(Arrays.toString(shortestPath(V2, edges2, src2)));
    }
}
