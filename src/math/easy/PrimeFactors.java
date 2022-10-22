package math.easy;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/prime-factors5052/1
 *
 * Given a number N. Find its unique prime factors in increasing order.
 *
 * Example 1:
 * Input: N = 100
 * Output: [2, 5]
 *
 * Example 2:
 * Input: N = 1234567
 * Output: [127, 9721]
 */

public class PrimeFactors {
    private static boolean generated = false;
    private static final int N = 100000000;
    private static final int[] primes = new int[N + 10];
    private static final int[] lp = new int[N + 10];

    public static void main(String[] args) {
        int n = 1234567;

        System.out.println("Brute Force: " + Arrays.toString(primeFactorsBruteForce(n)));
        System.out.println("Sieve: " + Arrays.toString(primeFactorsSieve(n)));
    }

    private static int[] primeFactorsBruteForce(int n) {
        if (n == 1) {
            return new int[]{1};
        }

        if (isPrimes(n)) {
            return new int[]{n};
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; n > 1; i++) {
            if (isPrimes(i)) {
                boolean included = false;
                while ((n % i) == 0) {
                    n = n / i;
                    included = true;
                }
                if (included) {
                    list.add(i);
                }
            }
        }

        int[] result = new int[list.size()];
        int k = 0;

        for (int num : list) {
            result[k++] = num;
        }

        return result;
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

    private static int[] primeFactorsSieve(int n) {
        if (!generated) {
            generatePrimes();
        }

        if (n == 1) {
            return new int[]{1};
        }

        if (primes[n] == 0) {
            return new int[]{n};
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (n > 1) {
            int factor = lp[n];
            while ((n % factor) == 0) {
                n = n / factor;
            }
            list.add(factor);
        }

        int[] result = new int[list.size()];
        int k = 0;

        for (int num : list) {
            result[k++] = num;
        }

        return result;
    }

    private static void generatePrimes() {
        for (int i = 0; i <= N; i++) {
            lp[i] = i;
        }

        for (int i = 2; i * i <= N; i++) {
            if (primes[i] == 0) {
                lp[i] = i;
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = 1;
                    if (lp[j] == j) {
                        lp[j] = i;
                    }
                }
            }
        }

        generated = true;
    }
}
