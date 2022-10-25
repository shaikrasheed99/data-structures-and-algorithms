package bit_manipulation.easy;

/***
 * Problem 67 in Leetcode: https://leetcode.com/problems/add-binary/
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "1001010101011010101010110101111", b = "1010010101001010101010"
 * Output: "1001010110101101010100001011001"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */

public class AddBinary {
    public static void main(String[] args) {
        String a = "1001010101011010101010110101111", b = "1010010101001010101010";

        System.out.println("Brute Force: " + addBinaryBruteForce(a, b));
        System.out.println("Optimized: " + addBinaryOptimized(a, b));
    }

    private static String addBinaryBruteForce(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        char carry = '0';
        StringBuilder sb = new StringBuilder();

        while ((n >= 0) && (m >= 0)) {
            char bit1 = a.charAt(n);
            char bit2 = b.charAt(m);

            if ((bit1 == '1') && (bit2 == '1')) {
                if (carry == '1') {
                    sb.append('1');
                } else {
                    sb.append('0');
                    carry = '1';
                }
            } else if ((bit1 == '0') && (bit2 == '0')) {
                if (carry == '1') {
                    sb.append('1');
                    carry = '0';
                } else {
                    sb.append('0');
                }
            } else {
                if (carry == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            n--;
            m--;
        }

        while (n >= 0) {
            char bit = a.charAt(n);
            if (carry == '1') {
                if (bit == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = '0';
                }
            } else {
                sb.append(bit);
            }
            n--;
        }

        while (m >= 0) {
            char bit = b.charAt(m);
            if (carry == '1') {
                if (bit == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = '0';
                }
            } else {
                sb.append(bit);
            }
            m--;
        }

        if (carry == '1') {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    private static String addBinaryOptimized(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while ((n >= 0) || (m >= 0)) {
            int sum = 0;
            if ((n >= 0) && (a.charAt(n) == '1')) {
                sum++;
            }
            if ((m >= 0) && (b.charAt(m) == '1')) {
                sum++;
            }
            sum += carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
            n--;
            m--;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
