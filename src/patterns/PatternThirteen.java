package patterns;

/**
 * Print below pattern
 *      1             1
 *      1 2         2 1
 *      1 2 3     3 2 1
 *      1 2 3 4 4 3 2 1
 */

public class PatternThirteen {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j <= 2 * n) {
                int counter = 0;
                while (j <= i) {
                    counter++;
                    System.out.print(counter);
                    j++;
                }
                while (j <= 2 * n - i) {
                    System.out.print(" ");
                    j++;
                }
                while (j <= 2 * n) {
                    System.out.print(counter);
                    counter--;
                    j++;
                }
            }
            System.out.println();
        }
    }
}
