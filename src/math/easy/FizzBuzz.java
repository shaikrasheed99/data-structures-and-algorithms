package math.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 412 in Leetcode: https://leetcode.com/problems/fizz-buzz/
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *      answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 *      answer[i] == "Fizz" if i is divisible by 3.
 *      answer[i] == "Buzz" if i is divisible by 5.
 *      answer[i] == i (as a string) if none of the above conditions are true.
 */

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 35;
        System.out.println("Modulo approach: " + moduloApproach(n));
        System.out.println("Addition approach: " + additionApproach(n));
        System.out.println("String approach: " + stringApproach(n));
    }

    private static List<String> moduloApproach(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    private static List<String> additionApproach(int n) {
        ArrayList<String> list = new ArrayList<>();
        int three = 0, five = 0;
        for (int i = 1; i <= n; i++) {
            three++;
            five++;
            if ((three == 3) && (five == 5)) {
                list.add("FizzBuzz");
                three = 0;
                five = 0;
            } else if (three == 3) {
                list.add("Fizz");
                three = 0;
            } else if (five == 5) {
                list.add("Buzz");
                five = 0;
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    private static List<String> stringApproach(int n) {
        ArrayList<String> list = new ArrayList<>();
        int three = 0, five = 0;
        for (int i = 1; i <= n; i++) {
            String ans = "";
            three++;
            five++;
            if (three == 3) {
                ans += "Fizz";
                three = 0;
            }
            if (five == 5) {
                ans += "Buzz";
                five = 0;
            }
            if (ans.length() == 0) {
                list.add(Integer.toString(i));
            } else {
                list.add(ans);
            }
        }
        return list;
    }
}
