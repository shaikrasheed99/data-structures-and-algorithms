package bit_manipulation.medium;

/***
 * Problem 1680 in Leetcode: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 *
 * Given an integer n, return the decimal value of the binary string formed by concatenating
 * the binary representations of 1 to n in order, modulo 109 + 7.
 *
 * Example 1:
 * Input: n = 1
 * Output: 1
 *
 * Example 2:
 * Input: n = 3
 * Output: 27
 *
 * Example 3:
 * Input: n = 12
 * Output: 505379714
 */

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {
        int n = 12;

        System.out.println("Concatenation: " + concatenationOfBinaryNumbers(n));
    }

    private static int concatenationOfBinaryNumbers(int n) {
        final long mod = (long) (1e9 + 7);
        long decimal = 1;
        int numberOfBinaryDigits = 1;

        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                numberOfBinaryDigits++;
            }
            decimal = ((decimal << numberOfBinaryDigits) | i) % mod;
        }

        return (int) decimal;
    }
}
