package bit_manipulation.easy;

/***
 * Problem 1009 in Leetcode: https://leetcode.com/problems/complement-of-base-10-integer/
 * Problem 476 in Leetcode: https://leetcode.com/problems/number-complement/
 *
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 *
 * Example 1:
 * Input: n = 5
 * Output: 2
 *
 * Example 2:
 * Input: n = 7
 * Output: 0
 *
 * Example 3:
 * Input: n = 10
 * Output: 5
 */

public class NumberCompliment {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Compliment is: " + getCompliment(num));
    }

    private static int getCompliment(int num) {
        if (num == 0) {
            return 1;
        }

        int mask = 0;
        int not = ~num;

        while (num != 0) {
            mask = (mask << 1) | 1;
            num = num >> 1;
        }

        int result = not & mask;

        return result;
    }
}
