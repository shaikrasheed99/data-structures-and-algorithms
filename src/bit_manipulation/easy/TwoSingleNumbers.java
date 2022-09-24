package bit_manipulation.easy;

import java.util.Arrays;

/***
 * Problem 260 in Leetcode: https://leetcode.com/problems/single-number-iii/
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 *
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 *
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 */

public class TwoSingleNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        System.out.println("Distinct numbers: " + Arrays.toString(findTwoDistinctNumber(nums)));
    }

    private static int[] findTwoDistinctNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int setBit = (xor & (~(xor - 1)));

        System.out.println(Integer.toBinaryString(setBit));

        int first = 0, second = 0;
        for (int num : nums) {
            if ((num & setBit) == setBit) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        return new int[]{first, second};
    }
}
