package patterns;

/**
 * Print below pattern
 *      A
 *      B B
 *      C C C
 *      D D D D
 *      E E E E E
 */

public class PatternTen {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        char counter = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
            }
            System.out.println();
            counter++;
        }
    }
}
