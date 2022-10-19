package bit_manipulation.easy;

/***
 * Problem 405 in Leetcode: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 *
 * Given an integer num, return a string representing its hexadecimal representation.
 * For negative integers, two’s complement method is used.
 * All the letters in the answer string should be lowercase characters
 * and there should not be any leading zeros in the answer except for the zero itself.
 *
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 *
 * Example 1:
 * Input: num = 26
 * Output: "1a"
 *
 * Example 2:
 * Input: num = -1
 * Output: "ffffffff"
 */

public class ConvertANumberToHexadecimal {
    private static final char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) {
        int num = -1;

        System.out.println("Brute Force: " + convertIntoHexadecimalBruteForce(num));
        System.out.println("Bitwise: " + convertIntoHexadecimalBitwise(num));
    }

    private static String convertIntoHexadecimalBruteForce(int num) {
        if (num == 0) {
            return "0";
        }

        boolean isNegative = num < 0;

        num = isNegative ? (num + 1) * -1 : num;

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int r = num % 16;
            if (isNegative) {
                r = 15 - r;
            }
            char c = (char) (r < 10 ? r + '0' : r - 10 + 'a');
            sb.append(c);
            num /= 16;
        }

        if (isNegative) {
            while (sb.length() < 8) {
                sb.append('f');
            }
        }

        return sb.reverse().toString();
    }

    private static String convertIntoHexadecimalBitwise(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (num != 0) {
            int mask = 15;
            result.append(chars[(num & mask)]);
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}
