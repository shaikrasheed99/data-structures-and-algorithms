package math.easy;

/***
 * Problem 258 in Leetcode: https://leetcode.com/problems/add-digits/
 *
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Example 1:
 * Input: num = 38
 * Output: 2
 *
 * Example 2:
 * Input: num = 2147483647
 * Output: 1
 */

public class AddDigits {
    public static void main(String[] args) {
        int num = 2147483647;

        System.out.println("Brute Force: " + addDigitsBruteForce(num));
        System.out.println("Optimized: " + addDigitsOptimized(num));
    }

    private static int addDigitsBruteForce(int num) {
        while (num >= 10) {
            num = digitsSum(num);
        }

        return num;
    }

    private static int digitsSum(int num) {
        int sum = 0;

        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }

    private static int addDigitsOptimized(int num) {
        if (num == 0) {
            return 0;
        }

        if (num % 9 == 0) {
            return 9;
        }

        return num % 9;
    }
}
