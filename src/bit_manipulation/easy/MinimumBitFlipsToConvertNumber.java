package bit_manipulation.easy;

/***
 * Problem 2220 in Leetcode: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 *
 * A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.
 * For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it.
 * We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
 * Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
 *
 * Example 1:
 * Input: start = 10, goal = 7
 * Output: 3
 *
 * Example 2:
 * Input: start = 3, goal = 4
 * Output: 3
 */

public class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        int start = 31, goal = 2;

        System.out.println("Minimum bits: " + minimumBitsFlipsToConvertNumber(start, goal));
    }

    private static int minimumBitsFlipsToConvertNumber(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;

        while (xor != 0) {
            count++;
            xor = (xor & (xor - 1));
        }

        return count;
    }
}
