package patterns;

/**
 * Print below pattern
 *      E
 *      D E
 *      C D E
 *      B C D E
 *      A B C D E
 */

public class PatternTwelve {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            char counter = (char) ('A' + n - i);
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
