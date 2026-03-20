package dev.amerida.algoritms.leed_code.binary_tree.invert;

import java.util.LinkedList;
import java.util.Queue;

public class InvertSolution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public TreeNode invertTreeWithQueue(TreeNode root) {
        // base case
        if (root == null) return null;

        // initialize queue to facilitate level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);    // add root to queue

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();    // remove first element from queue

            // swap left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // If the left child exists, add it to the queue
            if (current.left != null) queue.add(current.left);
            // If the right child exists, add it to the queue
            if (current.right != null) queue.add(current.right);
        }

        // The tree is now inverted, return the original root
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
