package trees.easy;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * Problem 94 in Leetcode: https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [1]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 */

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Using Recursion: " + inorderTraversalUsingRecursion(root, list));
        System.out.println("Using Stack: " + inorderTraversalUsingStack(root));
        System.out.println("Using Morris Traversal: " + inorderTraversalUsingMorrisTraversal(root));
    }

    public static List<Integer> inorderTraversalUsingRecursion(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            inorderTraversalUsingRecursion(root.left, list);
            list.add(root.value);
            inorderTraversalUsingRecursion(root.right, list);
        }
        return list;
    }

    private static List<Integer> inorderTraversalUsingStack(TreeNode root) {
        TreeNode current = root;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.value);
            current = current.right;
        }
        return list;
    }

    private static List<Integer> inorderTraversalUsingMorrisTraversal(TreeNode root) {
        TreeNode current = root;
        ArrayList<Integer> list = new ArrayList<>();
        while (current != null) {
            if (current.left == null) {
                list.add(current.value);
                current = current.right;
            } else {
                TreeNode child = current.left;
                while (child.right != null) {
                    child = child.right;
                }
                child.right = current;
                TreeNode temp = current.left;
                current.left = null;
                current = temp;
            }
        }
        return list;
    }
}
