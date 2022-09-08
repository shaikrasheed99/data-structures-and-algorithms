package trees.easy;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * Problem 144 in Leetcode: https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [1]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 */

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Using Recursion: " + preorderUsingRecursion(root, list));
        System.out.println("Using Stack: " + preorderUsingStack(root));
    }

    private static List<Integer> preorderUsingRecursion(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.value);
            preorderUsingRecursion(root.left, list);
            preorderUsingRecursion(root.right, list);
        }
        return list;
    }

    private static List<Integer> preorderUsingStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.value);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
