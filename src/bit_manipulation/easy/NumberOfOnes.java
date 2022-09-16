package bit_manipulation.easy;

/***
 * Problem 191 in Leetcode: https://leetcode.com/problems/number-of-1-bits/
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, the input will be given as a signed integer type.
 * It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 3, the input represents the signed integer. -3.
 *
 * Example 1:
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 *
 * Example 2:
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 *
 * Example 3:
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 */

public class NumberOfOnes {
    public static void main(String[] args) {
        int n = 00000000000000000000000010000000;
        System.out.println("Number of 1's are: " + numberOfOnes(n));
    }

    private static int numberOfOnes(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
