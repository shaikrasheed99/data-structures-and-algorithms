package patterns;

/**
 * Print below pattern
 *      1
 *      2 2
 *      3 3 3
 *      4 4 4 4
 */

public class PatternFour {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
