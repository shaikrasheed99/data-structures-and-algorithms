package arrays.hard;

import java.util.Arrays;

/***
 * Problem 41 in Leetcode: https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 */

public class FirstMissingPositive {
    public static void main(String[] args) {
//        int[] nums = {7, 8, 9, 11, 12};
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Brute Force: " + firstMissingPositiveBruteForce(nums));
        System.out.println("Sorting: " + firstMissingPositiveSorting(nums));
        System.out.println("Count Array: " + firstMissingPositiveCountArray(nums));
        System.out.println("Swapping: " + firstMissingPositiveSwapping(nums));
        System.out.println("Negation: " + firstMissingPositiveNegation(nums));
    }

    private static int firstMissingPositiveBruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }

        return n + 1;
    }

    private static int firstMissingPositiveSorting(int[] nums) {
        Arrays.sort(nums);

        int missingNumber = 1;

        for (int num : nums) {
            if (num == missingNumber) {
                missingNumber++;
            }
        }

        return missingNumber;
    }

    private static int firstMissingPositiveCountArray(int[] nums) {
        int n = (int) 1e5 + 2;
        int[] count = new int[n];

        for (int num : nums) {
            if (num > 0) {
                count[num] = 1;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) {
                return i;
            }
        }

        return nums.length + 1;
    }

    private static int firstMissingPositiveSwapping(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int position = nums[i] - 1;
            while (((position >= 0) && (position < n)) && (nums[i] != nums[position])) {
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
                position = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != (nums[i] - 1)) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private static int firstMissingPositiveNegation(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = 0;
            }
        }

        for (int num : nums) {
            num = Math.abs(num);
            int index = num - 1;
            if ((index >= 0) && (index < n)) {
                if (nums[index] == 0) {
                    nums[index] = -(n + 1);
                } else if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int index = i - 1;
            if (nums[index] >= 0) {
                return i;
            }
        }

        return n + 1;
    }
}
