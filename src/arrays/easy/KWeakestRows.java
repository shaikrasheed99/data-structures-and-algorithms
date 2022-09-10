package arrays.easy;

import java.util.Arrays;

/***
 * Problem 1337 in Leetcode: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians.
 * That is, all the 1's will appear to the left of all the 0's in each row.
 * A row i is weaker than a row j if one of the following is true:
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 *
 * Return the indices of the k the weakest rows in the matrix ordered from weakest to strongest.
 *
 * Example 1:
 * Input: mat = [[1,1,0,0,0], [1,1,1,1,0], [1,0,0,0,0], [1,1,0,0,0], [1,1,1,1,1]]
 * k = 3
 * Output: [2,0,3]
 *
 * Input: mat = [[1,0,0,0], [1,1,1,1], [1,0,0,0], [1,0,0,0]]
 * k = 2
 * Output: [0,2]
 */

public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    private static int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] solders = new int[rows];

        for (int i = 0; i < rows; i++) {
            int ones = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    ones++;
                }
            }
            solders[i] = ones * 1000 + i;
        }

        Arrays.sort(solders);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = solders[i] % 1000;
        }
        return result;
    }
}
