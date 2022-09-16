package arrays.easy;

import java.util.Arrays;
import java.util.Stack;

/***
 * Problem 1475 in Leetcode: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 *
 * Given the array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop, if you buy the ith item,
 * then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise,
 * you will not receive any discount at all.
 *
 * Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.
 *
 * Example 1:
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 *
 * Example 3:
 * Input: prices = [10,1,1,6]
 * Output: [9,0,1,6]
 */

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        System.out.println("Brute Force: " + Arrays.toString(finalPricesBruteForce(prices)));
        
        prices = new int[]{8, 4, 6, 2, 3};
        System.out.println("Stack: " + Arrays.toString(finalPricesStack(prices)));
    }

    private static int[] finalPricesBruteForce(int[] prices) {
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            prices[i] -= getNextSmallerPrice(prices, i);
        }
        return prices;
    }

    private static int getNextSmallerPrice(int[] prices, int start) {
        int n = prices.length;

        if (start < n - 1) {
            for (int i = start + 1; i < n; i++) {
                if (prices[i] <= prices[start]) {
                    return prices[i];
                }
            }
        }
        return 0;
    }

    private static int[] finalPricesStack(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            int val = 0;
            if (!stack.isEmpty()) {
                val = stack.peek();
            }
            stack.push(prices[i]);
            prices[i] = prices[i] - val;
        }
        return prices;
    }
}
