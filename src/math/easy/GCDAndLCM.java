package math.easy;

/***
 * Given two numbers A and B. The task is to find out their LCM and GCD.
 *
 * Example 1:
 * Input: A = 5, B = 10
 * Output: 10 5
 *
 * Example 2:
 * Input: A = 14, B = 8
 * Output: 56 2
 */

public class GCDAndLCM {
    public static void main(String[] args) {
        int a = 14, b = 8;

        System.out.println("LCM is: " + findLCMOf(a, b));

        System.out.println("GCD using Brute Force is: " + findGCDUsingBruteForce(a, b));
        System.out.println("GCD using Euclidean Subtraction is: " + findGCDUsingEuclideanSubtraction(a, b));
        System.out.println("GCD using Euclidean Division is: " + findGCDUsingEuclideanDivision(a, b));
    }

    private static int findGCDUsingBruteForce(int a, int b) {
        int smaller = Math.min(a, b);

        for (int i = smaller; i >= 1; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                return i;
            }
        }
        return -1;
    }

    private static int findGCDUsingEuclideanSubtraction(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private static int findGCDUsingEuclideanDivision(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    private static int findLCMOf(int a, int b) {
        int gcd = findGCDUsingEuclideanDivision(a, b);
        return (a * b) / gcd;
    }
}
