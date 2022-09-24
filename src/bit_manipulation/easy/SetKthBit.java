package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/set-kth-bit3724/1
 *
 * Given a number N and a value K.
 * From the right, set the Kth bit in the binary representation of N.
 * The position of Least Significant Bit(or last bit) is 0, the second last bit is 1 and so on.
 *
 * Example 1:
 * Input: N = 10, K = 2
 * Output: 14
 *
 * Example 2:
 * Input: N = 15, K = 3
 * Output: 15
 */

public class SetKthBit {
    public static void main(String[] args) {
        int n = 15, k = 3;

        System.out.println("Set kth bit: " + setKthBit(n, k));
    }

    private static int setKthBit(int n, int k) {
        return (n | (1 << k));
    }
}
