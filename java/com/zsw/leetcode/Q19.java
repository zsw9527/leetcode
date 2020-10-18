package com.zsw.leetcode;

public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
//        for (int i = 2; i <= 5; i++) {
//            p.next = new ListNode(i);
//            p = p.next;
//        }
        p.next = null;
        head = new Q19().removeNthFromEnd(head, 1);
    }

}
