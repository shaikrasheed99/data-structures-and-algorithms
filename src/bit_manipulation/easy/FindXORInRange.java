package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1
 *
 * You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
 *
 * Example 1:
 * Input: L = 4, R = 8
 * Output: 8
 *
 * Example 2:
 * Input: L = 3, R = 7
 * Output: 3
 */

public class FindXORInRange {
    public static void main(String[] args) {
        int l = 4, r = 8;

        System.out.println("Brute Force: " + findXORInRangeBruteForce(l, r));
        System.out.println("Mod 4 method: " + findXORInRangeMod4(l, r));
    }

    private static int findXORInRangeBruteForce(int l, int r) {
        int xor = 0;

        for (int i = l; i <= r; i++) {
            xor ^= i;
        }

        return xor;
    }

    private static int findXORInRangeMod4(int l, int r) {
        int xorOfTotal = findXORInRangeOfN(r);

        int xorTillL = findXORInRangeOfN(l - 1);

        int actualXOR = xorTillL ^ xorOfTotal;

        return actualXOR;
    }

    private static int findXORInRangeOfN(int n) {
        int mod = n % 4;

        if (mod == 0) {
            return n;
        }

        if (mod == 1) {
            return 1;
        }

        if (mod == 2) {
            return n + 1;
        }

        return 0;
    }
}
