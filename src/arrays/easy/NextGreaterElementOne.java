package arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/***
 * Problem 496 in Leetcode: https://leetcode.com/problems/next-greater-element-i/
 *
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 */

public class NextGreaterElementOne {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println("Brute Force: " + Arrays.toString(nextGreaterElementBruteForce(nums1, nums2)));
        System.out.println("Stack: " + Arrays.toString(nextGreaterElementStack(nums1, nums2)));
    }

    private static int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = helperForBruteForce(nums2, nums1[i]);
        }
        return result;
    }

    private static int helperForBruteForce(int[] nums2, int value) {
        int n = nums2.length;

        for (int i = 0; i < n; i++) {
            if (nums2[i] == value) {
                if (i < n - 1) {
                    for (int j = i + 1; j < n; j++) {
                        if (nums2[j] > value) {
                            return nums2[j];
                        }
                    }
                    return -1;
                }
                return -1;
            }
        }
        return -1;
    }

    private static int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            int val = -1;
            if (!stack.isEmpty()) {
                val = stack.peek();
            }
            map.put(nums2[i], val);
            stack.push(nums2[i]);
        }

        int m = nums1.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
