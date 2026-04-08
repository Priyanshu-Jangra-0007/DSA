import java.util.*;
public class party {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = sc.nextInt();
        int arr[] = new int[n];
        // Input
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Initialize adjacency list (0 to n)
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Build graph
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                adj.get(0).add(i + 1);
            } else {
                adj.get(arr[i]).add(i + 1);
            }
        }
        // Visited array (FIXED SIZE)
        boolean vis[] = new boolean[n + 1];
        int ans = 0;
        // Run BFS from each root child
        for (int b : adj.get(0)) {
            ans = Math.max(bfs(b, vis, adj), ans);
        }
        System.out.println(ans);
    }

    public static int bfs(int src, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.add(src);
        vis[src] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int neigh : adj.get(node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        return count;
    }
}