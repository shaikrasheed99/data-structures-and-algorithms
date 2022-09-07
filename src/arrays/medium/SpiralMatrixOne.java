package arrays.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 54 in <a href="https://leetcode.com/problems/spiral-matrix/">Leetcode</a>
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralMatrixOne {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(simulation(matrix));
    }

    private static List<Integer> simulation(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, down = rows - 1;
        int direction = 0;

        while (left <= right && top <= down) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            } else if (direction == 3) {
                for (int i = down; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return list;
    }
}
