package patterns;

/**
 * Print below pattern
 *      1
 *      2 3
 *      4 5 6
 *      7 8 9 10
 */

public class PatternEight {
    public static void main(String[] args) {
        int n = 4;
        printPattern(n);
    }

    private static void printPattern(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }
}
