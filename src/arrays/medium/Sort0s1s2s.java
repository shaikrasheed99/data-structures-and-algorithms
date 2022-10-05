package arrays.medium;

import java.util.Arrays;

/***
 * Problem 75 in Leetcode: https://leetcode.com/problems/sort-colors/
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.print("Sorting: ");
        sortUsingMergesort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 2, 1, 1, 0};
        System.out.println("Counting sort: " + Arrays.toString(sortUsingCountingSort(nums)));

        nums = new int[]{2, 0, 1};
        System.out.println("Three Pointer: " + Arrays.toString(sortUsingThreePointer(nums)));
    }

    private static void sortUsingMergesort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            sortUsingMergesort(nums, start, mid);
            sortUsingMergesort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int firstHalf = start, secondHalf = mid + 1, index = 0;
        int[] temp = new int[nums.length];

        while ((firstHalf <= mid) && (secondHalf <= end)) {
            if (nums[firstHalf] < nums[secondHalf]) {
                temp[index++] = nums[firstHalf++];
            } else {
                temp[index++] = nums[secondHalf++];
            }
        }

        while (firstHalf <= mid) {
            temp[index++] = nums[firstHalf++];
        }

        while (secondHalf <= end) {
            temp[index++] = nums[secondHalf++];
        }

        index = 0;

        for (int i = start; i <= end; i++) {
            nums[i] = temp[index++];
        }
    }

    private static int[] sortUsingCountingSort(int[] nums) {
        int[] count = new int[3];

        for (int num : nums) {
            count[num]++;
        }

        int iter = 0, index = 0;
        while (iter < nums.length) {
            int value = count[index];
            for (int i = 1; i <= value; i++) {
                nums[iter++] = index;
            }
            index++;
        }

        return nums;
    }

    private static int[] sortUsingThreePointer(int[] nums) {
        int low = 0, middle = 0, high = nums.length - 1;

        while (middle <= high) {
            if (nums[middle] == 0) {
                swap(nums, low, middle);
                low++;
                middle++;
            } else if (nums[middle] == 2) {
                swap(nums, middle, high);
                high--;
            } else {
                middle++;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int low, int middle) {
        int temp = nums[low];
        nums[low] = nums[middle];
        nums[middle] = temp;
    }
}
