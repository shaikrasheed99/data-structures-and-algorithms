package arrays.medium;

import java.util.Arrays;

/***
 * Problem 1996 in Leetcode: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 *
 * You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense.
 * You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.
 * A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels.
 * More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.
 *
 * Return the number of weak characters.
 *
 * Example 1:
 * Input: properties = [[5,5],[6,3],[3,6]]
 * Output: 0
 *
 * Example 2:
 * Input: properties = [[2,2],[3,3]]
 * Output: 1
 *
 * Example 3:
 * Input: properties = [[1,5],[10,4],[4,3]]
 * Output: 1
 */

public class NumberOfWeakCharacters {
    public static void main(String[] args) {
        int[][] properties = {{1, 5}, {10, 4}, {4, 3}};
        System.out.println("Brute Force: " + numberOfWeakCharactersBruteForce(properties));
        System.out.println("Sorting: " + numberOfWeakCharactersSorting(properties));
    }

    public static int numberOfWeakCharactersBruteForce(int[][] properties) {
        int weak = 0;
        int rows = properties.length, cols = properties[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i != j) && ((properties[j][0] > properties[i][0]) && (properties[j][1] > properties[i][1]))) {
                    weak++;
                }
            }
        }
        return weak;
    }

    private static int numberOfWeakCharactersSorting(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int rows = properties.length;
        int maxDefense = Integer.MIN_VALUE;
        int weak = 0;

        for (int i = rows - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                weak++;
            } else {
                maxDefense = properties[i][1];
            }
        }
        return weak;
    }
}
