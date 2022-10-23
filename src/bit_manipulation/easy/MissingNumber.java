package bit_manipulation.easy;

import java.util.Arrays;

/***
 * Problem 268 in Leetcode: https://leetcode.com/problems/missing-number/
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Brute Force: " + missingNumberBruteForce(nums));
        System.out.println("Sorting: " + missingNumberSorting(nums));
        System.out.println("Formula: " + missingNumberFormula(nums));
        System.out.println("Bitwise: " + missingNumberBitwise(nums));
    }

    private static int missingNumberBruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int num : nums) {
                if (i == num) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }

        return -1;
    }

    private static int missingNumberSorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    private static int missingNumberFormula(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    private static int missingNumberBitwise(int[] nums) {
        int n = nums.length;
        int naturalXOR = 0;

        for (int i = 0; i <= n; i++) {
            naturalXOR ^= i;
        }

        int arrayXOR = 0;

        for (int num : nums) {
            arrayXOR ^= num;
        }

        return (naturalXOR ^ arrayXOR);
    }
}
