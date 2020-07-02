package com.zsw.leetcode;

public class Q143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);
        while (newHead != null) {
            ListNode tmp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = tmp;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
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
