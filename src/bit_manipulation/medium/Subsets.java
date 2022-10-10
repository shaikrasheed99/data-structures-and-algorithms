package bit_manipulation.medium;

import java.util.ArrayList;
import java.util.List;

/***
 * Problem 78 in Leetcode: https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println("Backtracking approach: " + getSubsetsBackTracking(nums));
        System.out.println("Bit Masking approach: " + getSubsetsBitMasking(nums));
    }

    private static List<List<Integer>> getSubsetsBackTracking(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrackHelper(0, subset, subsets, nums);

        return subsets;
    }

    private static void backtrackHelper(int index, List<Integer> subset, List<List<Integer>> subsets, int[] nums) {
        if (index >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        backtrackHelper(index + 1, subset, subsets, nums);

        subset.add(nums[index]);

        backtrackHelper(index + 1, subset, subsets, nums);

        subset.remove(subset.size() - 1);
    }

    private static List<List<Integer>> getSubsetsBitMasking(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        int limit = (1 << n);

        for (int mask = 0; mask < limit; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int index = 0; index < n; index++) {
                if (((mask >> index) & 1) == 1) {
                    subset.add(nums[index]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }
}
