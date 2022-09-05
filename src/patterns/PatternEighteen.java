package patterns;

/**
 * Print below pattern
 *          #
 *         ###
 *        #####
 *       #######
 *      #########
 *      #########
 *       #######
 *        #####
 *         ###
 *          #
 */

public class PatternEighteen {
    public static void main(String[] args) {
        int n = 10;
        printPattern(n);
    }

    private static void printPattern(int n) {
        int halfLimit = n / 2;
        for (int i = 1; i <= halfLimit; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        for (int i = halfLimit; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
