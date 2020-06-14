package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历，非递归版
 */
public class Q94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            res.add(top.val);
            stack.pop();
            if (top.right != null) {
                stack.push(top.right);
                top = top.right;
                while (top.left != null) {
                    stack.push(top.left);
                    top = top.left;
                }
            }
        }
        return res;
    }
}
