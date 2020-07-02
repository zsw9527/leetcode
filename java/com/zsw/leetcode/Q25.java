package com.zsw.leetcode;

public class Q25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            int i = 0;
            while (i < k && end != null) {
                end = end.next;
                i++;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }
        return dummy.next;
    }
}
