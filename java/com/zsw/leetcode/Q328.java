package com.zsw.leetcode;

public class Q328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode j = head;//奇数
        ListNode o = head.next;//偶数
        ListNode x = o;
        while (o != null && o.next != null) {
            j.next = o.next;
            j = j.next;
            o.next = j.next;
            o = o.next;
        }
        j.next = x;
        return head;
    }
}
