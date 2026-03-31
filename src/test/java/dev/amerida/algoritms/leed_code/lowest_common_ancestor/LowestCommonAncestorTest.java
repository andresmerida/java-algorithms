package dev.amerida.algoritms.leed_code.lowest_common_ancestor;

import dev.amerida.algoritms.leed_code.lowest_common_ancestor.LowestCommonAncestor.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {

    private LowestCommonAncestor lca;

    @BeforeEach
    void setUp() {
        lca = new LowestCommonAncestor();
    }

    /**
     * Tree:
     *        6
     *       / \
     *      2   8
     *     / \
     *    0   4
     */
    private TreeNode[] buildTree() {
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n8 = new TreeNode(8);
        TreeNode n0 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        n6.left = n2; n6.right = n8;
        n2.left = n0; n2.right = n4;
        return new TreeNode[]{n6, n2, n8, n0, n4};
    }

    @Test
    void pIsRoot_returnsRoot() {
        TreeNode[] tree = buildTree();
        TreeNode root = tree[0], p = tree[0], q = tree[1];

        assertSame(p, lca.lowestCommonAncestor(root, p, q));
    }

    @Test
    void qIsRoot_returnsRoot() {
        TreeNode[] tree = buildTree();
        TreeNode root = tree[0], p = tree[1], q = tree[0];

        assertSame(q, lca.lowestCommonAncestor(root, p, q));
    }

    @Test
    void pFoundOnLeftSubtree_returnsPNode() {
        // p=2 (val=2): 6 < 2? No → left → hit 2==p
        TreeNode[] tree = buildTree();
        TreeNode root = tree[0], p = tree[1], q = tree[2];

        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        assertSame(p, result);
        assertEquals(2, result.val);
    }

    @Test
    void pFoundOnRightSubtree_returnsPNode() {
        // p=8 (val=8): 6 < 8? Yes → right → hit 8==p
        TreeNode[] tree = buildTree();
        TreeNode root = tree[0], p = tree[2], q = tree[1];

        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        assertSame(p, result);
        assertEquals(8, result.val);
    }

    @Test
    void pIsLeaf_returnsPLeafNode() {
        // p=0 (val=0): 6<0? No→left→2, 2<0? No→left→0==p
        TreeNode[] tree = buildTree();
        TreeNode root = tree[0], p = tree[3], q = tree[4];

        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        assertSame(p, result);
        assertEquals(0, result.val);
    }

    @Test
    void nullRoot_returnsNull() {
        TreeNode p = new TreeNode(1), q = new TreeNode(2);
        assertNull(lca.lowestCommonAncestor(null, p, q));
    }

    @Test
    void singleNodeTree_nodeIsP_returnsIt() {
        TreeNode root = new TreeNode(5);
        assertSame(root, lca.lowestCommonAncestor(root, root, root));
    }
}