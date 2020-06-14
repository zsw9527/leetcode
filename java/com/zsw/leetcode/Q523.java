package com.zsw.leetcode;

public class Q523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; ++i) {
            int s = nums[i];
            for (int j = i+1; j < nums.length; ++j) {
                s += nums[j];
                if (s == 0) {
                    return true;
                }
                if (k != 0 && s % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
