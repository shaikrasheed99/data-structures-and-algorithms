package math.medium;

/***
 * Problem 7 in Leetcode: https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 */

public class ReverseInteger {
    public static void main(String[] args) {
        int num = -123;
        System.out.println("Reversed Integer is: " + getReverseInteger(num));
    }

    private static int getReverseInteger(int num) {
        int reversed = 0;

        while (num != 0) {
            if ((reversed < Integer.MIN_VALUE / 10) || (reversed > Integer.MAX_VALUE / 10)) {
                return 0;
            }
            reversed = (reversed * 10) + (num % 10);
            num = num / 10;
        }
        return reversed;
    }
}
