package bit_manipulation.medium;

/***
 * Problem 29 in Leetcode: https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
 * For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 */

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = 10, divisor = -3;

        System.out.println("Brute Force: " + divideTwoIntegersBruteForce(dividend, divisor));
        System.out.println("Bitwise: " + divideTwoIntegersBitwise(dividend, divisor));
    }

    private static int divideTwoIntegersBruteForce(int dividend, int divisor) {
        if ((dividend == (-(1 << 31))) && (divisor == -1)) return (1 << 31) - 1;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;

        while ((dividend - divisor) >= 0) {
            count++;
            dividend -= divisor;
        }

        return count * sign;
    }

    private static int divideTwoIntegersBitwise(int dividend, int divisor) {
        if ((dividend == (-(1 << 32))) && (divisor == -1)) return (1 << 31) - 1;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;

        while ((dividend - divisor) >= 0) {
            int count = 1;
            int sub = divisor;
            while ((dividend - (sub << 1)) >= 0) {
                sub <<= 1;
                count <<= 1;
            }
            result += count;
            dividend -= sub;
        }
        return result * sign;
    }
}
