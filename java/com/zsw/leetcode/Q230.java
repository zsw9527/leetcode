package com.zsw.leetcode;

public class Q230 {

    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        kthSmallest(root, k, res);
        return res;
    }

    void kthSmallest(TreeNode root, int k, int res) {
        if (root == null) return;
        kthSmallest(root.left, k, res);
        ++i;
        if (i == k) {
            res = root.val;
            return;
        }
        kthSmallest(root.right, k, res);
    }
}
