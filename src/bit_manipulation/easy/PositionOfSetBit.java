package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
 *
 * Given a number N having only one ‘1’ and all other ’0’s in its binary representation, find position of the only set bit.
 * If there are 0 or more than 1 set bit the answer should be -1. Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.
 *
 * Example 1:
 * Input: N = 2
 * Output: 2
 *
 * Example 2:
 * Input: N = 5
 * Output: -1
 */

public class PositionOfSetBit {
    public static void main(String[] args) {
        int n = 2;

        System.out.println("Number of set bits: " + positionOfSetBit(n));
    }

    private static int positionOfSetBit(int n) {
        if (n <= 0) {
            return -1;
        }

        if ((n & (n - 1)) == 0) {
            int count = 0;
            while (n != 0) {
                count++;
                if ((n & 1) == 1) {
                    return count;
                }
                n >>= 1;
            }
        }

        return -1;
    }
}
