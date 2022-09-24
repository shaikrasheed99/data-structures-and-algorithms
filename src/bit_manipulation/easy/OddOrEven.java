package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/odd-or-even3618/1
 *
 * Given a positive integer N, determine whether it is odd or even.
 *
 * Example 1:
 * Input: N = 1
 * Output: Odd
 *
 * Example 2:
 * Input: N = 2
 * Output: Even
 */

public class OddOrEven {
    public static void main(String[] args) {
        int n = 1;

        System.out.println("Odd or Even? " + isOddOrEven(n));
    }

    private static String isOddOrEven(int n) {
        return ((n & 1) == 1) ? "Odd" : "Even";
    }
}
