package com.zsw.leetcode;

public class Q53 {
	
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);	
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, -2};
		int res = new Q53().maxSubArray(arr);
		System.out.println(res);
	}
}
