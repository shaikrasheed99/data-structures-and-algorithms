package bit_manipulation.medium;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
 *
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 *
 * Example 1:
 * Input: N = 4
 * Output: 5
 *
 * Example 2:
 * Input: N = 9999999
 * Output: 114434624
 */

public class CountTotalSetBits {
    public static void main(String[] args) {
        int n = 9999999;

        System.out.println("Brute Force: " + getCountOfTotalSetBitsBruteForce(n));
        System.out.println("Recursion: " + getCountOfTotalSetBitsRecursion(n));
    }

    private static int getCountOfTotalSetBitsBruteForce(int n) {
        int totalNumberOfSetBits = 0;

        for (int i = 1; i <= n; i++) {
            int number = i, numberOfSetBits = 0;
            while (number != 0) {
                if ((number & 1) == 1) {
                    numberOfSetBits++;
                }
                number >>= 1;
            }
            totalNumberOfSetBits += numberOfSetBits;
        }

        return totalNumberOfSetBits;
    }

    private static int getCountOfTotalSetBitsRecursion(int n) {
        if (n == 0) return 0;

        int largestPowerOfTwoToTheN = getLargestPowerOfTwoToTheN(n);

        int numberOfSetBitsTillLargestPowerOfTwo = largestPowerOfTwoToTheN * (1 << (largestPowerOfTwoToTheN - 1));

        int numberOfSetBitsInMsb = n - (1 << largestPowerOfTwoToTheN) + 1;

        int remainingSetBits = n - (1 << largestPowerOfTwoToTheN);

        int totalSetBits = numberOfSetBitsTillLargestPowerOfTwo + numberOfSetBitsInMsb + getCountOfTotalSetBitsRecursion(remainingSetBits);

        return totalSetBits;
    }

    private static int getLargestPowerOfTwoToTheN(int n) {
        int numberOfBits = (int) ((Math.log(n) / Math.log(2)) + 1);

        return numberOfBits - 1;
    }
}
