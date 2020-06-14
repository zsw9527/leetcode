package com.zsw.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q662 {

    private static class Node {
        TreeNode root;
        int depth;
        int pos;
        public Node(TreeNode root, int depth, int pos) {
            this.root = root;
            this.depth = depth;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(root, 0, 0));
        int curDepth = 0, left = 0;
        int res = 1;
        while (!que.isEmpty()) {
            Node t = que.poll();
            if (t.root != null) {
                que.offer(new Node(t.root.left, t.depth + 1, t.pos * 2));
                que.offer(new Node(t.root.right, t.depth + 1, t.pos * 2 + 1));
                if (curDepth != t.depth) {
                    curDepth = t.depth;
                    left = t.pos;
                }
                res = Math.max(res, t.pos - left);
            }
        }
        return res;
     }

}
