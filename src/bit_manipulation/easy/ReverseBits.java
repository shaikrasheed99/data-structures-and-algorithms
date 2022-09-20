package bit_manipulation.easy;

/***
 * Problem 190 in Leetcode: https://leetcode.com/problems/reverse-bits/
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example 1:
 * Input: n = 42949672 (00000010100011110101110000101000)
 * Output: 339407168 (00010100001110101111000101000000)
 *
 * Example 2:
 * Input: n = 42996 (00000000000000001010011111110100)
 * Output: 803536896 (00101111111001010000000000000000)
 */

public class ReverseBits {
    public static void main(String[] args) {
        int num = 42949672;

        System.out.println("Reverse bit value is: " + getReverseBitValue(num));
    }

    private static int getReverseBitValue(int num) {
        int reverse = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (num >> i) & 1;
            reverse = reverse | (bit << (31 - i));
        }
        return reverse;
    }
}
