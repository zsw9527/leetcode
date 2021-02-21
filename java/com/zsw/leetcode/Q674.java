package com.zsw.leetcode;

public class Q674 {

    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int start = 0;
        int i;
        for (i = 0; i <= nums.length - 1; ++i) {
            if (i > 0 && nums[i] <= nums[i-1]) {
                start = i;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        new Q674().findLengthOfLCIS(nums);
    }
}
