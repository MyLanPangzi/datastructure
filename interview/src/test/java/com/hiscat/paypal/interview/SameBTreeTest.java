package com.hiscat.paypal.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameBTreeTest {

    /**
     * Given two binary trees, write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     * Example 1:
     * Input:   [1,2,3], [1,2,3]
     * Output:  true
     * Example 2:
     * Input:    [1,2], [1,null,2]
     * Output:   false
     */
    @Test
    void same() {
        SameBTree.TreeNode t1 = new SameBTree.TreeNode(1);
        t1.left = new SameBTree.TreeNode(2);
        t1.right = new SameBTree.TreeNode(3);
        SameBTree.TreeNode t2 = new SameBTree.TreeNode(1);
        t2.left = new SameBTree.TreeNode(2);
        t2.right = new SameBTree.TreeNode(3);
        assertTrue(SameBTree.same(t1, t2));

        SameBTree.TreeNode t3 = new SameBTree.TreeNode(1);
        t3.left = new SameBTree.TreeNode(2);
        SameBTree.TreeNode t4 = new SameBTree.TreeNode(1);
        t3.left = null;
        t3.right = new SameBTree.TreeNode(2);
        assertFalse(SameBTree.same(t3, t4));

    }
}