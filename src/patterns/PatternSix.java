package patterns;

/**
 * Print below pattern
 *      1 2 3 4 5
 *      1 2 3 4
 *      1 2 3
 *      1 2
 *      1
 */

public class PatternSix {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
