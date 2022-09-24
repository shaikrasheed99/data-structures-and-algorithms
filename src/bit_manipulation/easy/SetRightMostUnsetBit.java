package bit_manipulation.easy;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1
 *
 * Given a non-negative number N.
 * The problem is to set the rightmost unset bit in the binary representation of N.
 * If there are no unset bits, then just leave the number as it is.
 *
 * Example 1:
 * Input: N = 6
 * Output: 7
 *
 * Example 2:
 * Input: N = 15
 * Output: 15
 */

public class SetRightMostUnsetBit {
    public static void main(String[] args) {
        int n = 11;

        System.out.println("Right most set bit number is: " + setRightMostUnsetBit(n));
    }

    private static int setRightMostUnsetBit(int n) {
        int temp = n;
        int found = 0;
        int count = 0;

        while (temp != 0) {
            if ((temp & 1) == 0) {
                found = 1;
                break;
            }
            count++;
            temp >>= 1;
        }

        if (found == 1) {
            int mask = (1 << count);
            return (n | mask);
        }
        return n;
    }
}
