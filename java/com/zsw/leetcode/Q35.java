package com.zsw.leetcode;

public class Q35 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            return target > nums[0] ? 1 : 0;
        }
        for (int i = 0; i <= nums.length - 2; ++i) {
            if (target <= nums[0]) {
                return 0;
            }
            if (target > nums[i] && target <= nums[i+1]) {
                return i+1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(new Q35().searchInsert(nums,0));
    }
}
