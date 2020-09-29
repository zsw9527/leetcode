package com.zsw.leetcode;

public class Q1367 {

    boolean res = false;

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null || root == null) return false;
        if (head.val == root.val) {
        	find(head, root);
        }
        return res || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    public void find(ListNode head, TreeNode root) {
    	if (head == null) {
    		res = true;
    		return;
    	}
    	if (root == null) return;
    	if (head.val == root.val) {
    		find(head.next, root.left);
    		find(head.next, root.right);
    	}
    }

}
