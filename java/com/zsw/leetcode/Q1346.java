package com.zsw.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q1346 {

	public boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int zeroNum = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == 0) zeroNum++;
			set.add(arr[i]);
		}
		if (zeroNum != 0 && zeroNum % 2 == 0) return true;
		for (int i = 0; i < arr.length; ++i) {
			if (set.contains(arr[i] * 2) && arr[i] * 2 != 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2,0,10,-19,4,6,-8};
		Q1346 q1346 = new Q1346();
		System.out.println(q1346.checkIfExist(arr));
	}

}
