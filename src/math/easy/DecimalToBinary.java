package math.easy;

/***
 * Given a decimal number as input, we need to write a program to convert the given decimal number into an equivalent binary number.
 *
 * Example 1:
 * Input : 7
 * Output : 111
 *
 * Example 2:
 * Input : 10
 * Output : 1010
 *
 * Example 3:
 * Input: 33
 * Output: 100001
 */

public class DecimalToBinary {
    public static void main(String[] args) {
        int num = 33;
        System.out.println("Binary number is: " + convertDecimalToBinary(num));
    }

    private static int convertDecimalToBinary(int num) {
        int binary = 0, base = 1;
        while (num != 0) {
            int bit = num & 1;
            binary = bit * base + binary;
            base = base * 10;
            num = num >> 1;
        }
        return binary;
    }
}
