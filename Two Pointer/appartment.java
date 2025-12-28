<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class appartment {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] apl = new int[n];
        for (int i = 0; i < n; i++) {
            apl[i] = sc.nextInt();
        }

        int[] app = new int[m];
        for (int i = 0; i < m; i++) {
            app[i] = sc.nextInt();
        }

        Arrays.sort(apl);
        Arrays.sort(app);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            int diff = apl[i] - app[j];

            if (Math.abs(diff) <= k) {
                count++;
                i++;
                j++;
            } else if (diff < -k) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(count);
    }
}
=======
import java.io.*;
import java.util.*;

public class appartment {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] apl = new int[n];
        for (int i = 0; i < n; i++) {
            apl[i] = sc.nextInt();
        }

        int[] app = new int[m];
        for (int i = 0; i < m; i++) {
            app[i] = sc.nextInt();
        }

        Arrays.sort(apl);
        Arrays.sort(app);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            int diff = apl[i] - app[j];

            if (Math.abs(diff) <= k) {
                count++;
                i++;
                j++;
            } else if (diff < -k) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(count);
    }
}
>>>>>>> 2070c85 (Add Dynamic Programming folder)
