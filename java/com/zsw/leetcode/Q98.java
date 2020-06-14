package com.zsw.leetcode;

public class Q98 {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && low >= root.val) return false;
        if (high != null && root.val >= high) return false;

        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
