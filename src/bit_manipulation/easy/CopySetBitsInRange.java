package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1
 *
 * Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32.
 * Find the set bits of y in range [l, r] and set these bits in x also.
 *
 * Example 1:
 * Input: X = 44, Y = 3, L = 1,  R = 5
 * Output: 47
 *
 * Example 2:
 * Input: X = 1000000000, Y = 1000000000, L = 1,  R = 32
 * Output: 1073736448
 */

public class CopySetBitsInRange {
    public static void main(String[] args) {
        int x = 44, y = 3, l = 1, r = 5;

        System.out.println("Brute Force: " + copySetBitsBruteForce(x, y, l, r));
        System.out.println("Bitwise shifting with mask: " + copySetBitsBitwise(x, y, l, r));
    }

    private static int copySetBitsBruteForce(int x, int y, int l, int r) {
        for (int i = l; i <= r; i++) {
            int shift = (i - 1);
            int mask = (1 << shift);
            if (((y >> shift) & 1) == 1) {
                x = x | mask;
            }
        }

        return x;
    }

    private static int copySetBitsBitwise(int x, int y, int l, int r) {
        int range = (r - l + 1);

        int allSetBitsOfRange = (int) ((1L << range) - 1);

        int mask = (allSetBitsOfRange << (l - 1)) & y;

        x = x | mask;

        return x;
    }
}
