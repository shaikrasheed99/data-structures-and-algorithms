package math.easy;

import linkedlist.ListNode;

/***
 * Problem 1290 in Leetcode: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 * The most significant bit is at the head of the linked list.
 *
 * Example 1:
 * Input: head = [1,1,0,1]
 * Output: 13
 *
 * Example 2:
 * Input: head = [1,0,1,0]
 * Output: 10
 */

public class BinaryLinkedListToDecimal {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);

        System.out.println("Brute Force: " + convertBinaryLinkedListToDecimalBruteForce(head));
        System.out.println("Bitwise: " + convertBinaryLinkedListToDecimalBitwise(head));
    }

    private static int convertBinaryLinkedListToDecimalBruteForce(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int base = (int) Math.pow(2, length - 1);
        int decimal = 0;

        while (head != null) {
            decimal = head.val * base + decimal;
            base = base / 2;
            head = head.next;
        }

        return decimal;
    }

    private static int convertBinaryLinkedListToDecimalBitwise(ListNode head) {
        if (head == null) {
            return 0;
        }

        int decimal = 0;

        while (head != null) {
            decimal = (decimal << 1) | head.val;
            head = head.next;
        }

        return decimal;
    }
}
