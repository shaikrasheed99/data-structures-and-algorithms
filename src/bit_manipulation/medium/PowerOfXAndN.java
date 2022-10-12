package bit_manipulation.medium;

/***
 * Problem 50 in Leetcode: https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 */

public class PowerOfXAndN {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2;

        System.out.println("Recursion: " + getPowerOfRecursion(x, n));
        System.out.println("Iterative: " + getPowerOfIterative(x, n));
    }

    private static double getPowerOfRecursion(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if ((n % 2) == 1) {
            return x * getPowerOfRecursion(x, n - 1);
        } else if ((n % 2) == 0) {
            return getPowerOfRecursion(x * x, n / 2);
        } else {
            return (1 / getPowerOfRecursion(x, -n));
        }
    }

    private static double getPowerOfIterative(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while (n != 0) {
            if ((n & 1) == 1) {
                pow = pow * x;
            }
            x = x * x;
            n >>>= 1;
        }

        return pow;
    }
}
