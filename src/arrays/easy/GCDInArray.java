package arrays.easy;

/***
 * Problem 1979 in Leetcode: https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 *
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 *
 * Example 1:
 * Input: nums = [2,5,6,9,10]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [7,5,6,8,3]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [3,3]
 * Output: 3
 */

public class GCDInArray {
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 8, 3};

        System.out.println("GCD is: " + getGcdInArray(nums));
    }

    private static int getGcdInArray(int[] nums) {
        int[] numbers = getSmallerAndLargerNumbersIn(nums);
        int smaller = numbers[0];
        int larger = numbers[1];

        return getGcdOf(smaller, larger);
    }

    private static int[] getSmallerAndLargerNumbersIn(int[] nums) {
        int[] numbers = new int[2];
        int n = nums.length;
        int start = 0, smaller = 99999, larger = -1;

        if (isEven(n)) {
            start = 2;
            smaller = Math.min(nums[0], nums[1]);
            larger = Math.max(nums[0], nums[1]);
        } else {
            start = 1;
            smaller = Math.min(nums[0], smaller);
            larger = Math.max(nums[0], larger);
        }

        for (int i = start; i < n; i += 2) {
            smaller = Math.min(nums[i], smaller);
            larger = Math.max(nums[i], larger);
            smaller = Math.min(nums[i + 1], smaller);
            larger = Math.max(nums[i + 1], larger);
        }

        numbers[0] = smaller;
        numbers[1] = larger;

        return numbers;
    }

    private static int getGcdOf(int smaller, int larger) {
        while (smaller != 0) {
            int temp = larger;
            larger = smaller;
            smaller = temp % smaller;
        }

        return larger;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
