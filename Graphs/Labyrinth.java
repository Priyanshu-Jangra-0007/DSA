import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Labyrinth {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];
        char[][] parent = new char[n][m];
        char[][] grid = new char[n][m];

        int sr = 0, sc = 0, er = 0, ec = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'A') { sr = i; sc = j; }
                if (grid[i][j] == 'B') { er = i; ec = j; }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && !visited[nr][nc]
                        && (grid[nr][nc] == '.' || grid[nr][nc] == 'B')) {

                    visited[nr][nc] = true;
                    parent[nr][nc] = dir[i];
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        if (!visited[er][ec]) {
            bw.write("NO\n");
            bw.flush();
            return;
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

        bw.write("YES\n");
        bw.write(path.size() + "\n");
        for (char c : path) bw.write(c);
        bw.write("\n");

        bw.flush();
    }
}
