package math.medium;

import java.util.ArrayList;

/***
 * Problem 1390 in Leetcode: https://leetcode.com/problems/four-divisors/
 *
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 * If there is no such integer in the array, return 0.
 *
 * Example 1:
 * Input: nums = [21,4,7]
 * Output: 32
 *
 * Example 2:
 * Input: nums = [21,21]
 * Output: 64
 *
 * Example 3:
 * Input: nums = [7286,18704,70773,8224,91675]
 * Output: 10932
 */

public class FourDivisors {
    public static void main(String[] args) {
        int[] nums = {7286, 18704, 70773, 8224, 91675};

        System.out.println("Brute Force: " + getFourDivisorsSumBruteForce(nums));
        System.out.println("Sieve: " + getFourDivisorsSumSieve(nums));
        System.out.println("Only two divisors between 1 and num: " + getFourDivisorsSumOptimized(nums));
    }

    private static int getFourDivisorsSumBruteForce(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += sumOfFourDivisorsOf(num);
        }

        return sum;
    }

    private static int sumOfFourDivisorsOf(int num) {
        int sum = 0, count = 0;

        for (int i = 1; i * i <= num; i++) {
            if ((num % i) == 0) {
                count++;
                sum += i;
                if (i != (num / i)) {
                    count++;
                    sum += (num / i);
                }
            }
        }

        if (count == 4) {
            return sum;
        }

        return 0;
    }

    private static int getFourDivisorsSumSieve(int[] nums) {
        int n = (int) 1e5 + 2;
        ArrayList<Integer>[] divisors = new ArrayList[n];

        divisors[1] = new ArrayList<>();
        divisors[1].add(1);

        for (int i = 2; i < n; i++) {
            divisors[i] = new ArrayList<>();
            divisors[i].add(1);
            divisors[i].add(i);
        }

        for (int i = 2; i < n; i++) {
            for (int j = i + i; j < n; j += i) {
                divisors[j].add(i);
            }
        }

        int sum = 0;

        for (int num : nums) {
            int count = divisors[num].size();

            if (count == 4) {
                for (int element : divisors[num]) {
                    sum += element;
                }
            }
        }

        return sum;
    }

    private static int getFourDivisorsSumOptimized(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if ((sqrt * sqrt) == num) {
                continue;
            }

            int count = 0;
            int sum = 1 + num;

            for (int i = 2; i <= sqrt; i++) {
                if ((num % i) == 0) {
                    count++;
                    sum += (i + (num / i));
                }

                if (count >= 2) {
                    break;
                }
            }

            if (count == 1) {
                totalSum += sum;
            }
        }

        return totalSum;
    }
}
