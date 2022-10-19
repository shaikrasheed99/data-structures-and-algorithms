package math.easy;

/***
 * Problem 1175 in Leetcode: https://leetcode.com/problems/prime-arrangements/
 *
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: n = 5
 * Output: 12
 *
 * Example 2:
 * Input: n = 100
 * Output: 682289015
 */

public class PrimeArrangements {
    public static void main(String[] args) {
        int n = 100;

        System.out.println("Brute Force: " + primeArrangementsBruteForce(n));
        System.out.println("Sieve: " + primeArrangementsSieve(n));
    }

    private static int primeArrangementsBruteForce(int n) {
        int numberOfPrimes = numberOfPrimesIn(n);

        long result = 1;

        result = getFactorialWithMod(numberOfPrimes, result);
        result = getFactorialWithMod(n - numberOfPrimes, result);

        return (int) result;
    }

    private static int primeArrangementsSieve(int n) {
        int numberOfPrimes = numberOfPrimesUsingSieve(n);

        long result = 1;

        result = getFactorialWithMod(numberOfPrimes, result);
        result = getFactorialWithMod(n - numberOfPrimes, result);

        return (int) result;
    }

    private static int numberOfPrimesUsingSieve(int n) {
        int[] primes = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                count++;
            }
        }

        return count;
    }

    private static long getFactorialWithMod(int a, long fact) {
        int mod = (int) 1e9 + 7;

        for (int i = 1; i <= a; i++) {
            fact = (i * fact) % mod;
        }

        return fact;
    }

    private static int numberOfPrimesIn(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if ((n == 2) || (n == 3)) {
            return true;
        }

        if ((n % 2 == 0) || (n % 3 == 0)) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
