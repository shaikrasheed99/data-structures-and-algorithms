package arrays.medium;

import java.util.Arrays;

/**
 * Problem 2326 in Leetcode: https://leetcode.com/problems/spiral-matrix-iv/
 *
 * You are given two integers m and n, which represent the dimensions of a matrix.
 *
 * You are also given the head of a linked list of integers.
 *
 * Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise),
 * starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.
 *
 * Example 1:
 * Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 *
 * Example 2:
 * Input: m = 1, n = 4, head = [0,1,2]
 * Output: [[0,1,2,-1]]
 */

public class SpiralMatrixFour {
    public static void main(String[] args) {
        int m = 3, n = 5;
        int[] head = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        System.out.println(Arrays.deepToString(spiralMatrix(m, n, head)));
    }

    public static int[][] spiralMatrix(int m, int n, int[] head) {
        int[][] matrix = new int[m][n];
        int left = 0, right = n - 1, top = 0, down = m - 1;
        int direction = 0, index = 0;

        while (left <= right && top <= down) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    if (index < head.length) {
                        matrix[top][i] = head[index];
                        index++;
                    } else {
                        matrix[top][i] = -1;
                    }
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= down; i++) {
                    if (index < head.length) {
                        matrix[i][right] = head[index];
                        index++;
                    } else {
                        matrix[i][right] = -1;
                    }
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    if (index < head.length) {
                        matrix[down][i] = head[index];
                        index++;
                    } else {
                        matrix[down][i] = -1;
                    }
                }
                down--;
            } else if (direction == 3) {
                for (int i = down; i >= top; i--) {
                    if (index < head.length) {
                        matrix[i][left] = head[index];
                        index++;
                    } else {
                        matrix[i][left] = -1;
                    }
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}