class Solution {
    public String maxSumOfSquares(int num, int sum) {
        return sum > 9 * num ? "" : ("9".repeat(sum / 9) + sum % 9 + "0".repeat(num)).substring(0, num);
    }
}