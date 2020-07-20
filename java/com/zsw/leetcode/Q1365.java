package com.zsw.leetcode;

public class Q1365 {

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		for (int i = 0; i < len; ++i) {
			int count = 0;
			for (int j = 0; j < len; ++j) {
				if (nums[i] > nums[j]) {
					count++;
				}
			}
			res[i] = count;
		}
		return res;
    }
}
