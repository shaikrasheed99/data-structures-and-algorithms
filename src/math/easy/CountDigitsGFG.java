package math.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/count-digits5716/1
 *
 * Given a number N. Count the number of digits in N which evenly divides N.
 *
 * Example 1:
 * Input: n = 12
 * Output: 2
 *
 * Example 2:
 * Input: n = 23
 * Output: 0
 *
 * Example 3:
 * Input: n = 103
 * Output: 1
 */

public class CountDigitsGFG {
    public static void main(String[] args) {
        int n = 103;

        System.out.println("Digits: " + findEvenlyDivisibleDigits(n));
    }

    private static int findEvenlyDivisibleDigits(int n) {
        int count = 0;
        int temp = n;

        while (temp != 0) {
            int digit = temp % 10;
            if ((digit != 0) && ((n % digit) == 0)) {
                count++;
            }
            temp = temp / 10;
        }

        return count;
    }
}
