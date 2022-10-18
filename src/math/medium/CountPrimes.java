package math.medium;

/***
 * Problem 204 in Leetcode: https://leetcode.com/problems/count-primes/
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 *
 * Example 2:
 * Input: n = 5000000
 * Output: 348513
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 */

public class CountPrimes {
    private static int generated;
    private static final int N = (int) 5e6 + 2;
    private static final int[] primes = new int[N];

    public static void main(String[] args) {
        int num = 5000000;

        System.out.println("Brute Force: " + getCountOfPrimesBruteForce(num));
        System.out.println("Sieve: " + getCountOfPrimesSieve(num));
    }

    private static int getCountOfPrimesBruteForce(int num) {
        int count = 0;

        for (int i = 2; i < num; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isPrimes(int num) {
        if (num <= 1) {
            return false;
        }

        if ((num == 2) || (num == 3)) {
            return true;
        }

        if ((num % 2 == 0) || (num % 3 == 0)) {
            return false;
        }

        for (int i = 5; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int getCountOfPrimesSieve(int num) {
        if (generated == 0) {
            generatePrimes();
        }

        int count = 0;

        for (int i = 2; i < num; i++) {
            if (primes[i] == 0) {
                count++;
            }
        }

        return count;
    }

    private static void generatePrimes() {
        for (int i = 2; i * i < N; i++) {
            if (primes[i] == 0) {
                for (int j = i * i; j < N; j += i) {
                    primes[j] = 1;
                }
            }
        }

        generated = 1;
    }
}
