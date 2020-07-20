package com.zsw.leetcode;

public class Q404 {
	
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
    }
	
	/**
	 * 
	 * @param root
	 * @param flag 标志该节点是否是左子节点
	 * @return 叶子节点和
	 */
	public int sumOfLeftLeaves(TreeNode root, boolean flag) {
		if (root == null) {
			return 0;
		}
		if (flag && root.left == null && root.right == null) {
			return root.val;
		}
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}

}
