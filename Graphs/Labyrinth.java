import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Labyrinth {

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean visited[][] = new boolean[n][m];
        char parent[][] = new char[n][m];
        char[][] grid = new char[n][m];
        int sr = 0, sc = 0, er = 0, ec = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'A') {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 'B') {
                    er = i;
                    ec = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            if (r == er && c == ec) break;
            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (nR >= 0 && nR < n && nC >= 0 && nC < m && !visited[nR][nC]
                        && (grid[nR][nC] == '.' || grid[nR][nC] == 'B')) {
                    visited[nR][nC] = true;
                    parent[nR][nC] = dir[i];
                    q.offer(new int[]{nR, nC});
                }
            }
        }

        ArrayList<Character> path = new ArrayList<>();
        int i = er, j = ec;
        while (i != sr || j != sc) {
            char p = parent[i][j];
            path.add(p);
            if (p == 'U') i++;
            else if (p == 'D') i--;
            else if (p == 'L') j++;
            else if (p == 'R') j--;
        }
        Collections.reverse(path);
        System.out.println("YES");
        System.out.println(path.size());
        for (char c : path) {
            System.out.print(c);
        }
        System.out.println();
    }
}
