package cf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AlternatingPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> adjL = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjL.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                adjL.get(u).add(v);
                adjL.get(v).add(u);
            }

            int[] color = new int[n + 1];
            int ans = 0;

            for (int i = 1; i <= n; i++) {
                if (color[i] != 0){
                    continue;
                }
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;
                int cnt1 = 1, cnt2 = 0;
                boolean bi = true;

                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adjL.get(u)) {
                        if (color[v] == 0) {
                            color[v] = -color[u];
                            if (color[v] == 1) cnt1++; else cnt2++;
                            q.add(v);
                        } else if (color[v] == color[u]) {
                            bi = false;
                        }
                    }
                }

                if (bi){
                    ans += Math.max(cnt1, cnt2);
                }
            }

            System.out.println(ans);
        }
    }
}