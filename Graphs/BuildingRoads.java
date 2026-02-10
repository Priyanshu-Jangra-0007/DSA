import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildingRoads {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int u) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        ArrayList<Integer> reps = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                reps.add(i);
                dfs(i);
            }
        }

        System.out.println(reps.size() - 1);
        for (int i = 0; i + 1 < reps.size(); i++) {
            System.out.println(reps.get(i) + " " + reps.get(i + 1));
        }
    }
}
