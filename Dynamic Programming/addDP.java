// import java.util.*;

// class Solution {

//     /* =====================================================
//        COMMON CONFIG
//        ===================================================== */
//     static final int LEN = 11;      // max digits (10^9)
//     static final int MASK = 1024;   // bitmask for digits 0–9

//     Integer[][][][][] dp;
//     String s;

//     /* =====================================================
//        1. Numbers With Repeated Digits (LC 1012)
//        ===================================================== */
//     public int numDupDigitsAtMostN(int n) {
//         s = String.valueOf(n);
//         dp = new Integer[LEN][2][2][MASK][2];
//         return solveDup(0, 1, 0, 0, 1);
//     }

//     private int solveDup(int idx, int tight, int rep, int mask, int lz) {
//         if (idx == s.length()) return rep;

//         if (dp[idx][tight][rep][mask][lz] != null)
//             return dp[idx][tight][rep][mask][lz];

//         int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
//         int res = 0;

//         for (int d = 0; d <= ub; d++) {
//             int ntight = (tight == 1 && d == ub) ? 1 : 0;

//             if (lz == 1 && d == 0) {
//                 res += solveDup(idx + 1, ntight, rep, mask, 1);
//             } else {
//                 int used = (mask >> d) & 1;
//                 int nrep = (rep == 1 || used == 1) ? 1 : 0;
//                 res += solveDup(idx + 1, ntight, nrep, mask | (1 << d), 0);
//             }
//         }

//         return dp[idx][tight][rep][mask][lz] = res;
//     }

//     /* =====================================================
//        2. Count Numbers With All Unique Digits
//        ===================================================== */
//     public int countUniqueDigits(int n) {
//         s = String.valueOf(n);
//         dp = new Integer[LEN][2][2][MASK][2];
//         return solveUnique(0, 1, 0, 0, 1);
//     }

//     private int solveUnique(int idx, int tight, int dup, int mask, int lz) {
//         if (idx == s.length()) return dup == 0 ? 1 : 0;

//         if (dp[idx][tight][dup][mask][lz] != null)
//             return dp[idx][tight][dup][mask][lz];

//         int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
//         int res = 0;

//         for (int d = 0; d <= ub; d++) {
//             int ntight = (tight == 1 && d == ub) ? 1 : 0;

//             if (lz == 1 && d == 0) {
//                 res += solveUnique(idx + 1, ntight, dup, mask, 1);
//             } else {
//                 if (((mask >> d) & 1) == 1) continue;
//                 res += solveUnique(idx + 1, ntight, 0, mask | (1 << d), 0);
//             }
//         }

//         return dp[idx][tight][dup][mask][lz] = res;
//     }

//     /* =====================================================
//        3. Count Numbers That Contain Digit 7
//        ===================================================== */
//     public int countHasSeven(int n) {
//         s = String.valueOf(n);
//         dp = new Integer[LEN][2][2][MASK][2];
//         return solveHas7(0, 1, 0, 0, 1);
//     }

//     private int solveHas7(int idx, int tight, int has7, int mask, int lz) {
//         if (idx == s.length()) return has7;

//         if (dp[idx][tight][has7][mask][lz] != null)
//             return dp[idx][tight][has7][mask][lz];

//         int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
//         int res = 0;

//         for (int d = 0; d <= ub; d++) {
//             int ntight = (tight == 1 && d == ub) ? 1 : 0;

//             if (lz == 1 && d == 0) {
//                 res += solveHas7(idx + 1, ntight, has7, mask, 1);
//             } else {
//                 int nhas7 = (has7 == 1 || d == 7) ? 1 : 0;
//                 res += solveHas7(idx + 1, ntight, nhas7, mask | (1 << d), 0);
//             }
//         }

//         return dp[idx][tight][has7][mask][lz] = res;
//     }

//     /* =====================================================
//        4. Count Numbers With No Repeated Digits
//           AND Digit Sum ≤ K
//        ===================================================== */
//     int K;

//     public int countNoRepeatSum(int n, int k) {
//         s = String.valueOf(n);
//         K = k;
//         dp = new Integer[LEN][2][2][MASK][2];
//         return solveSum(0, 1, 0, 0, 1);
//     }

//     private int solveSum(int idx, int tight, int sum, int mask, int lz) {
//         if (sum > K) return 0;
//         if (idx == s.length()) return 1;

//         int key = (sum > 0) ? 1 : 0;
//         if (dp[idx][tight][key][mask][lz] != null)
//             return dp[idx][tight][key][mask][lz];

//         int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
//         int res = 0;

//         for (int d = 0; d <= ub; d++) {
//             int ntight = (tight == 1 && d == ub) ? 1 : 0;

//             if (lz == 1 && d == 0) {
//                 res += solveSum(idx + 1, ntight, sum, mask, 1);
//             } else {
//                 if (((mask >> d) & 1) == 1) continue;
//                 res += solveSum(idx + 1, ntight, sum + d, mask | (1 << d), 0);
//             }
//         }

//         return dp[idx][tight][key][mask][lz] = res;
//     }
// }
