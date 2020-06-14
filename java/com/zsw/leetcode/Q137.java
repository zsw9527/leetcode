package com.zsw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q137 {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int tmp : nums) {
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 0);
			}
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return -1;
	}
}
