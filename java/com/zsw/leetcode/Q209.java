package com.zsw.leetcode;

public class Q209 {

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int k = 0, sum = 0;
            boolean flag = false;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                k++;
                if (sum >= s) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                res = Math.min(res, k);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int res = new Q209().minSubArrayLen(15, nums);
        System.out.println(res);
    }
}
