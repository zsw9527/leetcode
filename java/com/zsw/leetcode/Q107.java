package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q107 {

	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 List<List<Integer>> resList = new ArrayList<>();
		 if (root == null) return resList;
		 Deque<TreeNode> que = new LinkedList<TreeNode>();
		 que.offer(root);
		 while (!que.isEmpty()) {
			 List<Integer> curList = new ArrayList<Integer>();
			 int len = que.size();
			 for (int i = 0; i < len; ++i) {
				 TreeNode node = que.poll();
				 curList.add(node.val);
				 if (node.left != null) {
					 que.offer(node.left);
				 }
				 if (node.right != null) {
					 que.offer(node.right);
				 }
			 }
			 resList.add(0, curList);
		 }
		 
		 return resList;
	 }
}
