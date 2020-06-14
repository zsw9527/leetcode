package com.zsw.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        for (int i = 0; i <= nums.length; ++i) {
            backtrace(nums, 0, nums.length, i, new LinkedList<>(), output);
        }
        return output;
    }

    public void backtrace(int[] nums, int first, int n, int k, LinkedList<Integer> cur, List<List<Integer>> output) {
        if (cur.size() == k) {
            output.add(new LinkedList<>(cur));
        }
        for (int i = first; i < n; ++i) {
            cur.add(nums[i]);
            backtrace(nums,i+1, n, k, cur, output);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> output = new Q78().subsets(nums);
        output.stream().forEach(System.out::println);
    }
}
