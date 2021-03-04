package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q78 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; ++i) {
            dfs(nums, 0, i, new ArrayList<>());
        }
        return res;
    }

    private void dfs(int[] nums, int start, int len, List<Integer> cur) {
        if (cur.size() == len) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            dfs(nums, i+1, len, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> res = new Q78().subsets(nums);
        for (List<Integer> curList : res) {
            System.out.print("[");
            curList.forEach(a -> System.out.print(a + " "));
            System.out.print("]");
            System.out.println();
        }
    }
}
