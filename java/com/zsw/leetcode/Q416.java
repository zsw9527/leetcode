package com.zsw.leetcode;

/**
 * 回溯法在数据量特别大的情况会超时
 */
public class Q416 {

    boolean[] visited;

    int target;

    public boolean canPartition(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        visited = new boolean[nums.length];
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        if (sum % 2 != 0) {
            return false;
        }
        target = sum / 2;
        if (max > target) {
            return false;
        }
        return dfs(nums, 0, target);
    }

    private boolean dfs(int[] nums, int start, int s) {
        if (s < 0) {
            return false;
        }
        if (s == 0) {
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (!visited[i]) {
                    sum += nums[i];
                }
            }
            return sum == target;
        }
        boolean res = false;
        for (int i = start; i < nums.length; ++i) {
            s -= nums[i];
            visited[i] = true;
            res = res || dfs(nums, i+1, s);
            visited[i] = false;
            s += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(new Q416().canPartition(nums));
    }

}
