package com.zsw.leetcode;

public class Q1299 {
	
	public int[] replaceElements(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; ++i) {
			int j = i+1;
			int max = arr[j];
			for (; j < len; ++j) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			arr[i] = max;
		}
		arr[len-1] = -1;
		return arr;
    }
}