// import java.util.*;

// class Solution {

//     /* =====================================================
//        1. Longest Increasing Subsequence (O(n^2))
//        ===================================================== */
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int ans = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }

//     /* =====================================================
//        2. Print Longest Increasing Subsequence
//        ===================================================== */
//     public List<Integer> printLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         int[] parent = new int[n];

//         Arrays.fill(dp, 1);
//         for (int i = 0; i < n; i++) parent[i] = i;

//         int maxLen = 1, lastIdx = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
//                     dp[i] = dp[j] + 1;
//                     parent[i] = j;
//                 }
//             }
//             if (dp[i] > maxLen) {
//                 maxLen = dp[i];
//                 lastIdx = i;
//             }
//         }

//         List<Integer> lis = new ArrayList<>();
//         lis.add(nums[lastIdx]);

//         while (parent[lastIdx] != lastIdx) {
//             lastIdx = parent[lastIdx];
//             lis.add(nums[lastIdx]);
//         }

//         Collections.reverse(lis);
//         return lis;
//     }

//     /* =====================================================
//        3. Number of Longest Increasing Subsequences
//        ===================================================== */
//     public int findNumberOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] len = new int[n];
//         int[] cnt = new int[n];

//         Arrays.fill(len, 1);
//         Arrays.fill(cnt, 1);

//         int maxLen = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i]) {
//                     if (len[j] + 1 > len[i]) {
//                         len[i] = len[j] + 1;
//                         cnt[i] = cnt[j];
//                     } else if (len[j] + 1 == len[i]) {
//                         cnt[i] += cnt[j];
//                     }
//                 }
//             }
//             maxLen = Math.max(maxLen, len[i]);
//         }

//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             if (len[i] == maxLen) ans += cnt[i];
//         }
//         return ans;
//     }

//     /* =====================================================
//        4. Maximum Sum Increasing Subsequence
//        ===================================================== */
//     public int maxSumIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];

//         for (int i = 0; i < n; i++) dp[i] = nums[i];

//         int maxSum = nums[0];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] < nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + nums[i]);
//                 }
//             }
//             maxSum = Math.max(maxSum, dp[i]);
//         }
//         return maxSum;
//     }

//     /* =====================================================
//        5. Minimum Deletions to Make Array Increasing
//        ===================================================== */
//     public int minDeletions(int[] nums) {
//         return nums.length - lengthOfLIS(nums);
//     }

//     /* =====================================================
//        6. Russian Doll Envelopes (2D LIS)
//        ===================================================== */
//     public int maxEnvelopes(int[][] env) {
//         Arrays.sort(env, (a, b) -> {
//             if (a[0] == b[0]) return b[1] - a[1];
//             return a[0] - b[0];
//         });

//         int n = env.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int ans = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (env[j][1] < env[i][1]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }

//     /* =====================================================
//        7. Longest Bitonic Subsequence
//        ===================================================== */
//     public int longestBitonic(int[] nums) {
//         int n = nums.length;
//         int[] inc = new int[n];
//         int[] dec = new int[n];

//         Arrays.fill(inc, 1);
//         Arrays.fill(dec, 1);

//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < i; j++)
//                 if (nums[j] < nums[i])
//                     inc[i] = Math.max(inc[i], inc[j] + 1);

//         for (int i = n - 1; i >= 0; i--)
//             for (int j = n - 1; j > i; j--)
//                 if (nums[j] < nums[i])
//                     dec[i] = Math.max(dec[i], dec[j] + 1);

//         int ans = 1;
//         for (int i = 0; i < n; i++)
//             ans = Math.max(ans, inc[i] + dec[i] - 1);

//         return ans;
//     }

//     /* =====================================================
//        8. Longest Non-Decreasing Subsequence
//        ===================================================== */
//     public int LNDS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int ans = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] <= nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }

//     /* =====================================================
//        9. Longest Decreasing Subsequence
//        ===================================================== */
//     public int LDS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int ans = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[j] > nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }

//     /* =====================================================
//        10. LIS using Binary Search (O(n log n))
//        ===================================================== */
//     public int lengthOfLIS_BS(int[] nums) {
//         int[] tails = new int[nums.length];
//         int size = 0;

//         for (int num : nums) {
//             int l = 0, r = size;
//             while (l < r) {
//                 int m = (l + r) / 2;
//                 if (tails[m] < num) l = m + 1;
//                 else r = m;
//             }
//             tails[l] = num;
//             if (l == size) size++;
//         }
//         return size;
//     }

//     /* =====================================================
//        11. LIS with Given Difference (LeetCode 1218)
//        ===================================================== */
//     public int longestSubsequence(int[] arr, int diff) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int ans = 1;

//         for (int x : arr) {
//             int prev = map.getOrDefault(x - diff, 0);
//             map.put(x, prev + 1);
//             ans = Math.max(ans, prev + 1);
//         }
//         return ans;
//     }

//     /* =====================================================
//        12. Minimum Insertions to Make Array Increasing
//        ===================================================== */
//     public int minInsertions(int[] nums) {
//         return nums.length - lengthOfLIS(nums);
//     }

//     /* =====================================================
    //    13. Increasing Triplet Subsequence
//        ===================================================== */
//     public boolean increasingTriplet(int[] nums) {
//         int first = Integer.MAX_VALUE;
//         int second = Integer.MAX_VALUE;

//         for (int x : nums) {
//             if (x <= first) first = x;
//             else if (x <= second) second = x;
//             else return true;
//         }
//         return false;
//     }
// }
