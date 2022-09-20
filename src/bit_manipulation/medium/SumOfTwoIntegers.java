package bit_manipulation.medium;

/***
 * Problem 371 in Leetcode: https://leetcode.com/problems/sum-of-two-integers/
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 * Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 * Input: a = 2, b = -3
 * Output: -1
 */

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 2, b = -3;

        System.out.println("Sum using + operator: " + getSumUsingOperator(a, b));
        System.out.println("Sum using bitwise operator: " + getSumUsingBitwiseOperator(a, b));
    }

    private static int getSumUsingOperator(int a, int b) {
        return a + b;
    }

    private static int getSumUsingBitwiseOperator(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
