package arrays.easy;

import java.util.Arrays;

/***
 * Problem 905 in Leetcode: https://leetcode.com/problems/sort-array-by-parity/
 *
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 *
 * Example 1:
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};

        System.out.println("Even and Odd arrays approach: " + Arrays.toString(sortArray(nums)));
        System.out.println("Two Pass approach: " + Arrays.toString(sortArrayTwoPass(nums)));
        System.out.println("In place approach: " + Arrays.toString(sortArrayInPlace(nums)));
    }

    private static int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] evens = new int[n];
        int[] odds = new int[n];
        int even = 0, odd = 0;

        for (int num : nums) {
            if ((num & 1) == 0) {
                evens[even++] = num;
            } else {
                odds[odd++] = num;
            }
        }

        int[] result = new int[n];
        int index = 0, traverse = 0;

        while (traverse < even) {
            result[index++] = evens[traverse++];
        }

        traverse = 0;

        while (traverse < odd) {
            result[index++] = odds[traverse++];
        }

        return result;
    }

    private static int[] sortArrayTwoPass(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if ((num & 1) == 0) {
                result[index++] = num;
            }
        }

        for (int num : nums) {
            if ((num & 1) == 1) {
                result[index++] = num;
            }
        }

        return result;
    }

    private static int[] sortArrayInPlace(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if ((nums[start] & 1) == 1) {
                swap(nums, start, end);
                end--;
            } else if ((nums[end] & 1) == 0) {
                swap(nums, start, end);
                start++;
            } else {
                start++;
                end--;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
