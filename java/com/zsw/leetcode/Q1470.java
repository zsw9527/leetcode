package com.zsw.leetcode;

public class Q1470 {

    public int[] shuffle(int[] nums, int n) {
        int left = 0;
        int mid = n;
        int right = mid;
        int[] res = new int[2 * n];
        int j = 0;
        while (left <= mid - 1) {
            res[j++] = nums[left++];
            res[j++] = nums[right++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        new Q1470().shuffle(nums, 3);
    }
}
