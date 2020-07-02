package com.zsw.leetcode;

public class Q24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode f = head;
            ListNode s = head.next;
            f.next = s.next;
            s.next = f;
            pre.next = s;
            pre = f;
            head = f.next;
        }
        return dummy.next;
    }
}
