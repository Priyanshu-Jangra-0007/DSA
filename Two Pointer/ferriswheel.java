<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class ferriswheel {

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;
        int count = 0;

        while (i <= j) {
            if (arr[i] + arr[j] <= x) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }

        System.out.println(count);
    }
}
=======
import java.io.*;
import java.util.*;

public class ferriswheel {

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;
        int count = 0;

        while (i <= j) {
            if (arr[i] + arr[j] <= x) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }

        System.out.println(count);
    }
}
>>>>>>> 2070c85 (Add Dynamic Programming folder)
