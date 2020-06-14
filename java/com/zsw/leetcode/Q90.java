package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        resList.add(new ArrayList<>());
        for (int i = 0; i < n+1; ++i) {
            backtrace(nums, 0, n, i, new ArrayList<>(), resList);
        }
        return resList;
    }

    public void backtrace(int[] nums, int start, int n, int k, ArrayList<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = start; i < n; ++i) {
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }
            cur.add(nums[i]);
            backtrace(nums, i+1, n, k, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
