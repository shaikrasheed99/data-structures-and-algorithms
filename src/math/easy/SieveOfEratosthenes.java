package math.easy;

import java.util.ArrayList;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1
 *
 * Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes.
 *
 * Example 1:
 * Input: N = 10
 * Output: [2, 3, 5, 7]
 *
 * Example 2:
 * Input: N = 35
 * Output: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
 */

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 35;

        System.out.println("Primes numbers: " + primesUsingSieve(n));
    }

    private static ArrayList<Integer> primesUsingSieve(int n) {
        int[] primes = new int[n + 10];

        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }
}
