package com.zsw.leetcode;

import java.util.PriorityQueue;

/**
 * 合并k个升序链表
 * @author zsw
 *
 */
public class Leetcode23 {
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((x, y) -> x.val - y.val);

		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}

		ListNode head = new ListNode(-1);
		ListNode pNode = head;

		while (!queue.isEmpty()) {
			ListNode top = queue.poll();
			pNode.next = top;
			pNode = pNode.next;
			if (top.next != null) {
				queue.add(top.next);
			}
		}
		return head.next;
	}
}
