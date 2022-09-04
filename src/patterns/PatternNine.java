package patterns;

/**
 * Print below pattern
 *      A
 *      A B
 *      A B C
 *      A B C D
 *      A B C D E
 */

public class PatternNine {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            char counter = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
