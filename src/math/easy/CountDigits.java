package math.easy;

/***
 * Given an integer N , write program to count number of digits in N.
 *
 * Example 1:
 * Input: N = 12345
 * Output: 5
 *
 * Example 2:
 * Input: N = 8394
 * Output: 4
 */

public class CountDigits {
    public static void main(String[] args) {
        int n = 8394;
        System.out.println("Brute Force: " + countDigitsBruteForce(n));
        System.out.println("String Approach: " + countDigitsString(n));
        System.out.println("Logarithm Approach: " + countDigitsLogarithm(n));
    }

    private static int countDigitsBruteForce(int n) {
        int sum = 0;
        while (n > 0) {
            sum++;
            n /= 10;
        }
        return sum;
    }

    private static int countDigitsString(int n) {
        return String.valueOf(n).length();
    }

    private static int countDigitsLogarithm(int n) {
        return (int) Math.ceil(Math.log10(n));
    }
}
