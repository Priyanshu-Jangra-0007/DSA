import java.util.*;

public class WallsAndGates {

    static final int INF = 2147483647;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();
        // Add all gates to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && rooms[nr][nc] == INF) {
                    rooms[nr][nc] = rooms[cur.r][cur.c] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }

    public static void printMatrix(int[][] rooms) {
        for (int[] row : rooms) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };

        wallsAndGates(rooms);
        printMatrix(rooms);
    }
}
