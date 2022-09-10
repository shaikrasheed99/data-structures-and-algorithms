package arrays.easy;

/***
 * Problem 1672 in Leetcode: https://leetcode.com/problems/richest-customer-wealth/
 *
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank.
 *
 * Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts.
 *
 * The richest customer is the customer that has the maximum wealth.
 *
 * Example 1:
 * Input: accounts = [[1,2,3],[3,2,1]]
 * Output: 6
 *
 * Example 2:
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 *
 * Example 3:
 * Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * Output: 17
 */

public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] accounts = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(maximumWealth(accounts));
    }

    private static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int m = accounts.length, n = accounts[0].length;

        for (int i = 0; i < m; i++) {
            int sumWealth = 0;
            for (int j = 0; j < n; j++) {
                sumWealth += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sumWealth);
        }
        return maxWealth;
    }
}
