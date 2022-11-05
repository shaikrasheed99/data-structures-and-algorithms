package math.easy;

import java.util.HashSet;

/***
 * Problem 202 in Leetcode: https://leetcode.com/problems/happy-number/description/
 *
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 */

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;

        System.out.println("Set approach: " + isHappyNumberSetApproach(n));
        System.out.println("Two pointer: " + isHappyNumberTwoPointer(n));
    }

    private static boolean isHappyNumberSetApproach(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                break;
            }
            set.add(n);
            n = getSumOfDigitPower(n);
        }
        return n == 1;
    }

    private static boolean isHappyNumberTwoPointer(int n) {
        if (n == 1) {
            return true;
        }

        int slow = getSumOfDigitPower(n);
        int fast = getSumOfDigitPower(getSumOfDigitPower(n));

        while (slow != fast) {
            slow = getSumOfDigitPower(slow);
            fast = getSumOfDigitPower(getSumOfDigitPower(fast));
        }

        return slow == 1;
    }

    private static int getSumOfDigitPower(int n) {
        int sum = 0;

        while (n != 0) {
            int rem = n % 10;
            sum = sum + (rem * rem);
            n = n / 10;
        }

        return sum;
    }
}
