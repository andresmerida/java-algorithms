package dev.amerida.algoritms.leed_code.lowest_common_ancestor;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (current == p || current == q) {
                return current;
            }
            current = current.val < p.val ? current.right : current.left;
        }

        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
