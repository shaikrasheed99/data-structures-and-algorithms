package math.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
 *
 * Given a positive integer N., The task is to find the value of F(i) where function F(i) for the number i be defined as the sum of all divisors of ‘i‘.
 *
 * Example 1:
 * Input: n = 4
 * Output: 15
 *
 * Example 2:
 * Input: n = 5
 * Output: 21
 */

public class SumOfAllDivisors {
    public static void main(String[] args) {
        int n = 4;

        System.out.println("Divisors sum is: " + findSumOfAllDivisors(n));
    }

    private static int findSumOfAllDivisors(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += ((n / i) * i);
        }

        return sum;
    }
}
