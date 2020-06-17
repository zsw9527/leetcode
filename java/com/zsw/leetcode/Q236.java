package com.zsw.leetcode;

public class Q236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right == null) return left;
        if (right != null && left == null) return right;
        if (left == null && right == null) return null;
        return root;
    }
}
