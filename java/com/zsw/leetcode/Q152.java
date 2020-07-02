package com.zsw.leetcode;

public class Q152 {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        max[0] = nums[0];
        int[] min = new int[len];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            max[i] = Math.max(Math.max(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
