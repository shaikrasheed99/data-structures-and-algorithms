package bit_manipulation.easy;

import java.util.Arrays;

/***
 * Problem 338 in Leetcode: https://leetcode.com/problems/counting-bits/
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 * Input: n = 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 */

public class CountingBits {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Brute Force: " + Arrays.toString(countBitsBruteForce(num)));
        System.out.println("Dynamic Programming: " + Arrays.toString(countBitsDP(num)));
    }

    private static int[] countBitsBruteForce(int num) {
        if (num == 0) {
            return new int[]{0};
        }

        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                count++;
                n = (n & (n - 1));
            }
            result[i] = count;
        }

        return result;
    }

    private static int[] countBitsDP(int num) {
        if (num == 0) {
            return new int[]{0};
        }

        int[] result = new int[num + 1];
        result[0] = 0;

        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i % 2);
        }

        return result;
    }
}
