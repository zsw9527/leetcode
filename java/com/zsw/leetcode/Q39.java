package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;


public class Q39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(candidates, res, target, 0, new ArrayList<>());
		return res;
    }
	
	public void dfs(int[] candidates, List<List<Integer>> res, int target, Integer s, List<Integer> curList) {
		if (target < 0) return;
		if (target == 0) {
			res.add(new ArrayList<>(curList));
			return;
		}
		for (int i = s; i < candidates.length; ++i) {
			curList.add(candidates[i]);
			target -= candidates[i];
			dfs(candidates, res, target, i, curList);
			target += candidates[i];
			curList.remove(curList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		List<List<Integer>> resList = new Q39().combinationSum(arr, 3);
		for (List<Integer> tmpList : resList) {
			tmpList.stream().forEach(a -> System.out.print(a + " "));
			System.out.println();
		}
	}
}
