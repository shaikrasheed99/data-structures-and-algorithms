package math.easy;

/***
 * Problem 1281 in Leetcode: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *
 * Example 1:
 * Input: n = 234
 * Output: 15
 *
 * Example 2:
 * Input: n = 4421
 * Output: 21
 */

public class SubtractProductAndSum {
    public static void main(String[] args) {
        int n = 4421;
        System.out.println("Difference of product and sum is: " + subtractProductAndSum(n));
    }

    private static int subtractProductAndSum(int n) {
        int product = 1, sum = 0;

        while (n != 0) {
            int mod = n % 10;
            product *= mod;
            sum += mod;
            n /= 10;
        }
        return product - sum;
    }
}
