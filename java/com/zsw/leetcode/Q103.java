package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        int levelIndex = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                TreeNode top = queue.poll();
                if (top != null) {
                    if (levelIndex % 2 == 1) {
                        levelList.add(top.val);
                    } else {
                        levelList.add(0, top.val);
                    }
                    if (top.left != null) {
                        queue.offer(top.left);
                    }
                    if (top.right != null) {
                        queue.offer(top.right);
                    }
                }
            }
            res.add(levelList);
            levelIndex++;
        }
        return res;
    }
}
