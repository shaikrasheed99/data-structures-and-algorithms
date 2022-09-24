package bit_manipulation.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * Problem 136 in Leetcode: https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 */

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Brute Force: " + findSingleNumberBruteForce(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println("Sorting: " + findSingleNumberSorting(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println("Hashing: " + findSingleNumberHashing(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println("Bit Manipulation: " + findSingleNumberBitManipulation(nums));
    }

    private static int findSingleNumberBruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int count = 1;
                for (int j = i + 1; j < n; j++) {
                    if ((nums[i] != Integer.MAX_VALUE) && (nums[i] == nums[j])) {
                        count++;
                        nums[j] = Integer.MAX_VALUE;
                        break;
                    }
                }
                if (count == 1) {
                    return nums[i];
                }
            }
        }

        return nums[n - 1];
    }

    private static int findSingleNumberSorting(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            if ((nums[i] != nums[i - 1]) && (nums[i] != nums[i + 1])) {
                return nums[i];
            }
        }

        return nums[n - 1];
    }

    private static int findSingleNumberHashing(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.remove(num);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static int findSingleNumberBitManipulation(int[] nums) {
        int singleNumber = 0;

        for (int num : nums) {
            singleNumber ^= num;
        }

        return singleNumber;
    }
}
