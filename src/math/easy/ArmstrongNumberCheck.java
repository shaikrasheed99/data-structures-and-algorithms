package math.easy;

/***
 * Given a number, check if it is Armstrong Number or Not.
 *
 * Example 1:
 * Input: N = 153
 * Output: true
 *
 * Example 2:
 * Input: N = 170
 * Output: false
 */

public class ArmstrongNumberCheck {
    public static void main(String[] args) {
        int n = 153;
        System.out.println("Is Armstrong Number? " + armstrongCheck(n));
    }

    private static boolean armstrongCheck(int n) {
        int digits = (int) Math.ceil(Math.log10(n));
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int mod = temp % 10;
            sum = sum + ((int) Math.pow(mod, digits));
            temp /= 10;
        }
        return (sum == n);
    }
}
