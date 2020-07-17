package com.zsw.leetcode;

/**
 * 分两种情况讨论，要么将奇数位置的元素减少到刚好比相邻的偶数位置元素小，
 * 要么将偶数位置的元素减少到刚好比相邻的奇数位置元素小。返回两种情况操作较少的作为答案。
 */
public class Q1144 {
    
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int an1 = 0, an2 = 0;
        for (int i = 0; i < n; ++i) {
            int d1 = (i > 0 && nums[i] >= nums[i-1]) ? nums[i] - nums[i-1] + 1 : 0;
            int d2 = (i < n-1 && nums[i] >= nums[i+1]) ? nums[i] - nums[i+1] + 1 : 0;
            if (i % 2 == 0) {
                an1 += Math.max(d1, d2);
            } else {
                an2 += Math.max(d1, d2);
            }
        }
        return Math.min(an1, an2);
    }
}