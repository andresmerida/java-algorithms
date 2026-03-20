package dev.amerida.algoritms.leed_code.binary_tree.invert;

import org.junit.jupiter.api.Test;

import static dev.amerida.algoritms.leed_code.binary_tree.invert.InvertSolution.TreeNode;
import static org.junit.jupiter.api.Assertions.*;

class InvertSolutionTest {
    private final InvertSolution solution = new InvertSolution();

    // Helper: build tree from level-order array (null = absent node)
    private TreeNode build(Integer... vals) {
        if (vals.length == 0 || vals[0] == null) return null;
        TreeNode root = new TreeNode(vals[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            if (vals[i] != null) {
                node.left = new TreeNode(vals[i]);
                queue.add(node.left);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                node.right = new TreeNode(vals[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    // Helper: collect values via level-order traversal
    private int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        java.util.List<Integer> result = new java.util.ArrayList<>();
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // --- invertTree (recursive) ---

    @Test
    void invertTree_null_returnsNull() {
        assertNull(solution.invertTree(null));
    }

    @Test
    void invertTree_singleNode_returnsSameValue() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.invertTree(root).val);
    }

    @Test
    void invertTree_swapsChildren() {
        //     4
        //    / \
        //   2   7
        TreeNode root = build(4, 2, 7);
        TreeNode inverted = solution.invertTree(root);
        assertEquals(7, inverted.left.val);
        assertEquals(2, inverted.right.val);
    }

    @Test
    void invertTree_fullTree_levelOrder() {
        //        4
        //      /   \
        //     2     7
        //    / \   / \
        //   1   3 6   9
        // inverted:
        //        4
        //      /   \
        //     7     2
        //    / \   / \
        //   9   6 3   1
        TreeNode root = build(4, 2, 7, 1, 3, 6, 9);
        assertArrayEquals(new int[]{4, 7, 2, 9, 6, 3, 1}, levelOrder(solution.invertTree(root)));
    }

    @Test
    void invertTree_leftSkewed() {
        //   1
        //  /
        // 2
        TreeNode root = build(1, 2, null);
        TreeNode inverted = solution.invertTree(root);
        assertNull(inverted.left);
        assertEquals(2, inverted.right.val);
    }

    @Test
    void invertTree_rightSkewed() {
        //   1
        //    \
        //     2
        TreeNode root = build(1, null, 2);
        TreeNode inverted = solution.invertTree(root);
        assertEquals(2, inverted.left.val);
        assertNull(inverted.right);
    }

    @Test
    void invertTree_isSymmetricAfterDoubleInvert() {
        TreeNode root = build(4, 2, 7, 1, 3, 6, 9);
        int[] original = levelOrder(root);
        solution.invertTree(solution.invertTree(root));
        assertArrayEquals(original, levelOrder(root));
    }

    // --- invertTreeWithQueue (iterative) ---

    @Test
    void invertTreeWithQueue_null_returnsNull() {
        assertNull(solution.invertTreeWithQueue(null));
    }

    @Test
    void invertTreeWithQueue_singleNode_returnsSameValue() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.invertTreeWithQueue(root).val);
    }

    @Test
    void invertTreeWithQueue_swapsChildren() {
        TreeNode root = build(4, 2, 7);
        TreeNode inverted = solution.invertTreeWithQueue(root);
        assertEquals(7, inverted.left.val);
        assertEquals(2, inverted.right.val);
    }

    @Test
    void invertTreeWithQueue_fullTree_levelOrder() {
        TreeNode root = build(4, 2, 7, 1, 3, 6, 9);
        assertArrayEquals(new int[]{4, 7, 2, 9, 6, 3, 1}, levelOrder(solution.invertTreeWithQueue(root)));
    }

    @Test
    void invertTreeWithQueue_leftSkewed() {
        TreeNode root = build(1, 2, null);
        TreeNode inverted = solution.invertTreeWithQueue(root);
        assertNull(inverted.left);
        assertEquals(2, inverted.right.val);
    }

    @Test
    void invertTreeWithQueue_rightSkewed() {
        TreeNode root = build(1, null, 2);
        TreeNode inverted = solution.invertTreeWithQueue(root);
        assertEquals(2, inverted.left.val);
        assertNull(inverted.right);
    }

    @Test
    void bothMethods_produceIdenticalResults() {
        int[] levelOrderRecursive = levelOrder(solution.invertTree(build(4, 2, 7, 1, 3, 6, 9)));
        int[] levelOrderIterative = levelOrder(solution.invertTreeWithQueue(build(4, 2, 7, 1, 3, 6, 9)));
        assertArrayEquals(levelOrderRecursive, levelOrderIterative);
    }
}