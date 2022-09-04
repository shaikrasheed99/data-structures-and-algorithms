package patterns;

/**
 * Print below pattern
 *      A B C D E
 *      A B C D
 *      A B C
 *      A B
 *      A
 */

public class PatternEleven {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = n; i >= 1; i--) {
            char counter = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
