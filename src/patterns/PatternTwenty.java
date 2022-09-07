package patterns;

/**
 * Print below pattern
 *      4 4 4 4 4 4 4
 *      4 3 3 3 3 3 4
 *      4 3 2 2 2 3 4
 *      4 3 2 1 2 3 4
 *      4 3 2 2 2 3 4
 *      4 3 3 3 3 3 4
 *      4 4 4 4 4 4 4
 */

public class PatternTwenty {
    public static void main(String[] args) {
        int n = 4;
        printPattern(n);
    }

    private static void printPattern(int n) {
        int size = 2 * n - 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print(Math.max(Math.abs(i-n), Math.abs(j-n)) + 1 + " ");
            }
            System.out.println();
        }
    }
}
