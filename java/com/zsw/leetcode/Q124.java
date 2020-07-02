package com.zsw.leetcode;

public class Q124 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        maxSum = Math.max(maxSum, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}
