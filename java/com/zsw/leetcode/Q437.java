package com.zsw.leetcode;

public class Q437 {

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        priOrder(root, sum);
        return count;
    }

    public void priOrder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        findPath(root, sum);
        priOrder(root.left, sum);
        priOrder(root.right, sum);
    }

    public void findPath(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        findPath(root.left, sum);
        findPath(root.right, sum);
    }
}
