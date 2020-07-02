package com.zsw.leetcode;

public class Q92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        int i = 0;
        while (i < m - 1) {
            i++;
            pre = pre.next;
            p = p.next;
        }
        for (int j = 0; j < n - m; ++j) {
            ListNode next = p.next;
            p.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
