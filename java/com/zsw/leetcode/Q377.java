package com.zsw.leetcode;

public class Q377 {

    static class Res {
        int r = 0;
    }

    public int combinationSum4(int[] nums, int target) {
        Res res = new Res();
        combinationSum(nums, res, 0, target, 0);
        return res.r;
    }

    public void combinationSum(int[] num, Res res, int first, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.r += 1;
        }
        for (int i = 0; i < num.length; ++i) {
            sum += num[i];
            combinationSum(num, res, i, target, sum);
            sum -= num[i];
        }
    }


    public static int combinationSum(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=1;i<=target;i++) {
            for(int num:nums) {
                if(i>=num) {
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int res = combinationSum(nums, 4);
    }
}
