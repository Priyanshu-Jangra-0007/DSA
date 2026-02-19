import java.util.*;

public class GraphValidTree  {
    static int comp;

    public static boolean validTree(int n, int[][] edges) {
        int parent[] = new int[n];
        int rank[] = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;
        comp = n;

        for (int[] e : edges) {
            if (!union(e[0], e[1], parent, rank)) return false;
        }
        return comp == 1;
    }

    static boolean union(int x, int y, int parent[], int rank[]) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) return false;

        if (rank[px] > rank[py]) parent[py] = px;
        else if (rank[px] < rank[py]) parent[px] = py;
        else {
            parent[py] = px;
            rank[px]++;
        }
        comp--;
        return true;
    }

    static int find(int x, int parent[]) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.println(validTree(n, edges));
    }
}
