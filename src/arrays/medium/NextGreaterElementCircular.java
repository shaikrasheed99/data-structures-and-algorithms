package arrays.medium;

import java.util.Arrays;
import java.util.Stack;

/***
 * Problem 503 in Leetcode: https://leetcode.com/problems/next-greater-element-ii/
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, return -1 for this number.
 *
 * Example 1:
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 *
 * Example 2:
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 */

public class NextGreaterElementCircular {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println("Brute Force: " + Arrays.toString(nextGreaterElementBruteForce(nums)));
        System.out.println("Stack: " + Arrays.toString(nextGreaterElementStack(nums)));
    }

    private static int[] nextGreaterElementBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = helperForBruteForce(nums, nums[i]);
        }
        return result;
    }

    private static int helperForBruteForce(int[] nums, int value) {
        int n = nums.length;

        for (int i = 0; i < 2 * n; i++) {
            int mod = i % n;
            if (nums[mod] > value) {
                return nums[mod];
            }
        }
        return -1;
    }

    private static int[] nextGreaterElementStack(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            int val = -1;
            if (!stack.isEmpty()) {
                val = stack.peek();
            }
            result[i % n] = val;
            stack.push(nums[i % n]);
        }
        return result;
    }
}
