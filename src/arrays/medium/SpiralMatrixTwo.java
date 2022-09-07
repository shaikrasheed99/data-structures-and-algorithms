package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 59 in Leetcode: https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 */

public class SpiralMatrixTwo {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int direction = 0, counter = 1;

        while (left <= right && top <= down) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = counter;
                    counter++;
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= down; i++) {
                    matrix[i][right] = counter;
                    counter++;
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = counter;
                    counter++;
                }
                down--;
            } else if (direction == 3) {
                for (int i = down; i >= top; i--) {
                    matrix[i][left] = counter;
                    counter++;
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}
