package arrays.easy;

/***
 * Problem 485 in Leetcode: https://leetcode.com/problems/max-consecutive-ones/
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 */

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};

        System.out.println("Number of One's: " + getMaxConsecutiveOnes(nums));
    }

    private static int getMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
                maxCount = Math.max(count, maxCount);
            }
        }

        return maxCount;
    }
}
