package arrays.easy;

import java.util.Arrays;

/***
 * Problem in GeeksForGeeks: https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
 *
 * Given an array of length N consisting of only 0s and 1s in random order.
 * Modify the array to segregate 0s on left side and 1s on the right side of the array.
 *
 * Example 1:
 * Input: nums = [0, 1, 0, 1, 0]
 * Output: [0, 0, 0, 1, 1]
 */

public class Segregate0sAnd1s {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0};

        System.out.print("Sorting: ");
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 1, 0, 1, 0};
        System.out.println("Counting sort: " + Arrays.toString(sortUsingCountingSort(nums)));

        nums = new int[]{0, 1, 0, 1, 0};
        System.out.println("Two Pointer: " + Arrays.toString(sortUsingTwoPointers(nums)));
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
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
        int[] count = new int[2];

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

    private static int[] sortUsingTwoPointers(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            while ((start < end) && (nums[start] == 0)) {
                start++;
            }
            while ((end > start) && (nums[end] == 1)) {
                end--;
            }
            if (start < end) {
                swap(nums, start, end);
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int start, int middle) {
        int temp = nums[start];
        nums[start] = nums[middle];
        nums[middle] = temp;
    }
}
