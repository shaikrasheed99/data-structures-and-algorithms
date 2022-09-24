package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
 *
 * Given a number N and a bit number K, check if Kth bit of N is set or not.
 * A bit is called set if it is 1. Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
 *
 * Example 1:
 * Input: N = 4, K = 0
 * Output: No
 *
 * Example 2:
 * Input: N = 39, K = 5
 * Output: Yes
 */

public class CheckKthBitIsSet {
    public static void main(String[] args) {
        int n = 39, k = 5;

        System.out.println("Is Kth bit set? using Mask: " + hasKthBitAsSetUsingMask(n, k));
        System.out.println("Is Kth bit set? Right shift: " + hasKthBitAsSet(n, k));
    }

    private static boolean hasKthBitAsSetUsingMask(int n, int k) {
        int mask = (1 << k);
        return (n & mask) != 0;
    }

    private static boolean hasKthBitAsSet(int n, int k) {
        return ((n >> k) & 1) == 1;
    }
}
