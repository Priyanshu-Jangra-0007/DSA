import java.util.*;

public class BennyAndTheBrokenOdometer {

    public static long getRealDistance(long displayedValue) {
        long realDistance = 0;
        long base = 1;

        while (displayedValue > 0) {
            long digit = displayedValue % 10;
            if (digit > 3) {
                digit--;
            }

            realDistance += digit * base;
            base *= 9;
            displayedValue /= 10;
        }

        return realDistance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            long N = sc.nextLong();
            System.out.println(getRealDistance(N));
        }

        sc.close();
    }
}
