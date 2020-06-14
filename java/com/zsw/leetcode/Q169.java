package com.zsw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                int size = map.get(nums[i]);
                map.put(nums[i], ++size);
                if (size > nums.length / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Q169().majorityElement(nums));
    }
}