package math.easy;

/***
 * Problem 9 in Leetcode: https://leetcode.com/problems/palindrome-number/
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 */

public class PalindromeCheck {
    public static void main(String[] args) {
        int num = 121;
        System.out.println("Brute Force: " + palindromeCheckBruteForce(num));
        System.out.println("String: " + palindromeCheckString(num));
        System.out.println("Half reverse: " + palindromeCheckHalfReverse(num));
    }

    private static boolean palindromeCheckBruteForce(int num) {
        if (num < 0) {
            return false;
        }

        int temp = num;
        int sum = 0;

        while (temp > 0) {
            sum = sum * 10 + (temp % 10);
            temp /= 10;
        }
        return (sum == num);
    }

    private static boolean palindromeCheckString(int num) {
        if (num < 0) {
            return false;
        }

        String str = Integer.toString(num);
        int n = str.length();

        if (n == 1) {
            return true;
        }

        for (int i = 0; i < n / 2; i++) {
            if (!(str.charAt(i) == str.charAt(n - i - 1))) {
                return false;
            }
        }
        return true;
    }

    private static boolean palindromeCheckHalfReverse(int num) {
        if (num < 0) {
            return false;
        }

        if (num % 10 == 0 && num != 0) {
            return false;
        }

        int sum = 0;

        while (sum < num) {
            sum = sum * 10 + (num % 10);
            num /= 10;
        }

        return (num == sum || num == sum / 10);
    }
}