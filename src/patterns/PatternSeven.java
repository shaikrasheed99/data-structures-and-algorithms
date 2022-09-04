package patterns;

/**
 * Print below pattern
 *      1
 *      0 1
 *      1 0 1
 *      0 1 0 1
 *      1 0 1 0 1
 */

public class PatternSeven {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                counter = 0;
            } else {
                counter = 1;
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                if (counter == 0) {
                    counter = 1;
                } else {
                    counter = 0;
                }
            }
            System.out.println();
        }
    }
}
