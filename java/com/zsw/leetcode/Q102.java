package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode p = root;
        que.add(p);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> perList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = que.poll();
                perList.add(tmp.val);
                if (tmp.left != null) {
                    que.add(tmp.left);
                }
                if (tmp.right != null) {
                    que.add(tmp.right);
                }
            }
            resList.add(perList);
        }
        return resList;
    }
}