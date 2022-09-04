package patterns;

/**
 * Print below pattern
 *      # # # #
 *      # # #
 *      # #
 *      #
 */

public class PatternFive {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
