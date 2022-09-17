package math.easy;

/***
 * Given a binary number as input, we need to write a program to convert the given binary number into an equivalent decimal number.
 *
 * Example 1:
 * Input : 111
 * Output : 7
 *
 * Example 2:
 * Input : 1010
 * Output : 10
 *
 * Example 3:
 * Input: 100001
 * Output: 33
 */

public class BinaryToDecimal {
    public static void main(String[] args) {
        int binary = 100001;
        System.out.println("Decimal is: " + convertBinaryToDecimal(binary));
    }

    private static int convertBinaryToDecimal(int binary) {
        int decimal = 0;
        int base = 1;

        while (binary != 0) {
            int digit = binary % 10;
            decimal = digit * base + decimal;
            base = base * 2;
            binary = binary / 10;
        }
        return decimal;
    }
}
