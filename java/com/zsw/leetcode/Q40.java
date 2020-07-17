package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<Integer>(), 0, target, res);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> cur, int start, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (candidates[i] > target) continue;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            target -= candidates[i];
            cur.add(candidates[i]);
            dfs(candidates, cur, i+1, target, res);
            cur.remove(cur.size()-1);
            target += candidates[i];
        }
    }
}