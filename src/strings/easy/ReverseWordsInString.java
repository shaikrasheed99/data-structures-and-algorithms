package strings.easy;

/***
 * Problem 557 in Leetcode: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Example 2:
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println("Reversed string is: " + reverseWordsInString(s));
    }

    private static String reverseWordsInString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int start = 0, spaceFinder = 0;

        while (start < n) {
            while ((spaceFinder < n) && (chars[spaceFinder] != ' ')) {
                spaceFinder++;
            }
            int end = spaceFinder - 1;
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            start = spaceFinder + 1;
            spaceFinder++;
        }

        return new String(chars);
    }
}
