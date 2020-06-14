package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class face34 {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, cur, sum);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> cur, int sum) {
        if (root == null) return;
        cur.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(cur));
        }
        if (root.left != null) dfs(root.left, cur, sum);
        if (root.right != null) dfs(root.right, cur, sum);
        cur.remove(cur.size()-1);
    }
}
