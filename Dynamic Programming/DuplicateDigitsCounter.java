public class DuplicateDigitsCounter {

    Integer[][][][][] dp;
    static final int LEN = 11;
    static final int MASK = 1024;

    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        dp = new Integer[LEN][2][2][MASK][2];
        return solve(s, 0, 1, 0, 0, 1);
    }

    private int solve(String s, int idx, int tight, int rep, int mask, int lz) {
        if (idx == s.length()) {
            return rep;
        }

        if (dp[idx][tight][rep][mask][lz] != null) {
            return dp[idx][tight][rep][mask][lz];
        }

        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;

        for (int digit = 0; digit <= ub; digit++) {
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;

            if (lz == 1 && digit == 0) {
                res += solve(s, idx + 1, newTight, rep, mask, 1);
            } else {
                int isDigitUsed = (mask >> digit) & 1;
                int newRep = (rep == 1 || isDigitUsed == 1) ? 1 : 0;
                int newMask = mask | (1 << digit);

                res += solve(s, idx + 1, newTight, newRep, newMask, 0);
            }
        }

        return dp[idx][tight][rep][mask][lz] = res;
    }

    public static void main(String[] args) {
        DuplicateDigitsCounter solution = new DuplicateDigitsCounter();
        int n = 100;
        System.out.println(solution.numDupDigitsAtMostN(n));
    }
}
