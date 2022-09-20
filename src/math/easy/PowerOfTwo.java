package math.easy;

/***
 * Problem 231 in Leetcode: https://leetcode.com/problems/power-of-two/
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 * Example 1:
 * Input: n = 0
 * Output: false
 *
 * Example 2:
 * Input: n = 16
 * Output: true
 *
 * Example 3:
 * Input: n = 2147483647
 * Output: false
 */

public class PowerOfTwo {
    public static void main(String[] args) {
        int number = 1024;

        System.out.println("Loop Approach: " + isPowerOfTwoLoop(number));
        System.out.println("Recursion Approach: " + isPowerOfTwoRecursion(number));
        System.out.println("Logarithm Approach: " + isPowerOfTwoLogarithm(number));
        System.out.println("Bitwise Approach: " + isPowerOfTwoBitwise(number));
    }

    private static boolean isPowerOfTwoLoop(int number) {
        if (number <= 0) {
            return false;
        }

        while (number > 2) {
            if (isOdd(number)) {
                return false;
            }
            number >>= 1;
        }

        return true;
    }

    private static boolean isPowerOfTwoRecursion(int number) {
        if (number <= 0) {
            return false;
        }

        if (number == 1) {
            return true;
        }

        return !isOdd(number);
    }

    private static boolean isPowerOfTwoLogarithm(int number) {
        if (number <= 0) {
            return false;
        }

        int power = (int) (Math.log(number) / Math.log(2));

        return Math.pow(2, power) == number;
    }

    private static boolean isPowerOfTwoBitwise(int number) {
        boolean isGreaterThanZero = number > 0;

        boolean isAndOperationZero = (number & (number - 1)) == 0;

        return isGreaterThanZero && isAndOperationZero;
    }

    private static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
