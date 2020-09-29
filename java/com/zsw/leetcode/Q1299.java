package com.zsw.leetcode;

public class Q1299 {
	
	public int[] replaceElements(int[] arr) {
		/**
		 * 逆序遍历
		 */
		int len = arr.length;
		int[] res = new int[len];
		res[len - 1] = -1;
		for (int i = len - 2; i >= 0; i--) {
			res[i] = Math.max(res[i+1], arr[i+1]);
		}
		return res;
    }
}