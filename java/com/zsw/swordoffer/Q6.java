package com.zsw.swordoffer;

import java.util.Stack;

public class Q6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }
}
