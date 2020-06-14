package com.zsw.leetcode;

public class Q238 {
    
    public int[] productExceptSelf(int[] nums) {
        //前缀积
        int[] pre = new int[nums.length];
        pre[0] = 1;
        pre[1] = nums[0];
        for (int i = 2; i < nums.length; ++i) {
            pre[i] = pre[i-1] * nums[i-1];
        }
        //后缀积
        int[] post = new int[nums.length];
        post[nums.length-1] = 1;
        post[nums.length-2] = nums[nums.length-1];
        for (int i = nums.length - 3; i >= 0; i--) {
            post[i] = post[i+1] * nums[i+1];
        }
        int[] res = new int[nums.length];
        res[0] = post[0];
        res[nums.length-1] = pre[nums.length-1];
        for (int i = 1; i < nums.length-1; ++i) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Q238 q238 = new Q238();
        int[] nums = {1,2,3,4};
        int[] res = q238.productExceptSelf(nums);
        for (int tmp : res) {
            System.out.print(tmp + " ");
        }
    }
}