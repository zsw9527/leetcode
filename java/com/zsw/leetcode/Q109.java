package com.zsw.leetcode;

public class Q109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMidElement(head);
        TreeNode tree = new TreeNode(mid.val);
        tree.left = sortedListToBST(head);
        tree.right = sortedListToBST(mid.next);
        return tree;
    }

    ListNode findMidElement(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;//将链表断开
        }
        return slow;
    }
}
