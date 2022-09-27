package bit_manipulation.easy;

/***
 * Problem 137 in Leetcode: https://leetcode.com/problems/single-number-ii/
 *
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 */

public class OneSingleNumberInGroupOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};

        System.out.println("Bitwise Approach: " + findSingleNumberBitwise(nums));
    }

    private static int findSingleNumberBitwise(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int setBits = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    setBits++;
                }
            }
            if ((setBits % 3) != 0) {
                result = result | (1 << i);
            }
        }

        return result;
    }
}
