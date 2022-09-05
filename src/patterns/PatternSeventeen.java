package patterns;

/**
 * Print below pattern
 *             A
 *           A B A
 *          A B C B A
 *        A B C D C B A
 *      A B C D E D C B A
 */

public class PatternSeventeen {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            int limit = 2 * i - 1;
            char counter = 'A';
            for (int j = 1; j <= limit / 2; j++) {
                System.out.print(counter);
                counter++;
            }
            for (int j = limit / 2 + 1; j <= limit; j++) {
                System.out.print(counter);
                counter--;
            }
            System.out.println();
        }
    }
}
