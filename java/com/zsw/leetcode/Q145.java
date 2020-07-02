package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //Stack<Integer> resStack = new Stack<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode top = nodeStack.pop();
            res.add(0, top.val);
            if (top.left != null) {
                nodeStack.push(top.left);
            }
            if (top.right != null) {
                nodeStack.push(top.right);
            }
        }
        return res;
    }
}
