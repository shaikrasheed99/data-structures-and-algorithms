package patterns;

/***
 * Print below pattern
 *      # # # #
 *      # # # #
 *      # # # #
 *      # # # #
 */

public class PatternOne {
    public static void main(String[] args) {
        int n = 3;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
