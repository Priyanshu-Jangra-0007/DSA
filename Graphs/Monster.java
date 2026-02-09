import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Monster {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visitedP = new boolean[n][m];
        boolean[][] visitedM = new boolean[n][m];
        char[][] parent = new char[n][m];
        char[][] grid = new char[n][m];
        int[][] disM = new int[n][m];
        int[][] disP = new int[n][m];

        for (int[] row : disM) Arrays.fill(row, Integer.MAX_VALUE);
        for (int[] row : disP) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> mQ = new LinkedList<>();
        Queue<int[]> mP = new LinkedList<>();

        int pr = -1, pc = -1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'M') {
                    mQ.offer(new int[]{i, j});
                    disM[i][j] = 0;
                    visitedM[i][j] = true;
                }
                if (grid[i][j] == 'A') {
                    pr = i;
                    pc = j;
                    disP[i][j] = 0;
                    visitedP[i][j] = true;
                    mP.offer(new int[]{i, j});
                }
            }
        }

        // Monster BFS
        while (!mQ.isEmpty()) {
            int[] curr = mQ.poll();
            int r = curr[0], c = curr[1];
            int dis = disM[r][c];

            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (nR >= 0 && nC >= 0 && nR < n && nC < m
                        && !visitedM[nR][nC]
                        && (grid[nR][nC] == '.' || grid[nR][nC] == 'A')
                        && 1 + dis < disM[nR][nC]) {

                    disM[nR][nC] = 1 + dis;
                    visitedM[nR][nC] = true;
                    mQ.offer(new int[]{nR, nC});
                }
            }
        }

        int er = -1, ec = -1;

        // Player BFS
        while (!mP.isEmpty()) {
            int[] curr = mP.poll();
            int r = curr[0], c = curr[1];
            int dis = disP[r][c];

            if ((r == 0 || c == 0 || r == n - 1 || c == m - 1)
                    && dis < disM[r][c]) {
                er = r;
                ec = c;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                char direction = dir[i];

                if (nR >= 0 && nR < n && nC >= 0 && nC < m
                        && !visitedP[nR][nC]
                        && grid[nR][nC] == '.'
                        && 1 + dis < disP[nR][nC]
                        && 1 + dis < disM[nR][nC]) {

                    visitedP[nR][nC] = true;
                    disP[nR][nC] = 1 + dis;
                    mP.offer(new int[]{nR, nC});
                    parent[nR][nC] = direction;
                }
            }
        }

        // OUTPUT (added only)
        if (er == -1) {
            bw.write("NO\n");
            bw.flush();
            return;
        }

        StringBuilder path = new StringBuilder();
        int r = er, c = ec;
        while (r != pr || c != pc) {
            char p = parent[r][c];
            path.append(p);
            if (p == 'U') r++;
            else if (p == 'D') r--;
            else if (p == 'L') c++;
            else if (p == 'R') c--;
        }

        path.reverse();

        bw.write("YES\n");
        bw.write(path.length() + "\n");
        bw.write(path.toString() + "\n");
        bw.flush();
    }
}
