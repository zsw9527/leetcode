package com.zsw.leetcode;

import java.util.Arrays;

public class Q1051 {

    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for (int i = 0; i < heights.length; ++i) {
            arr[i] = heights[i];
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (arr[i] != heights[i]) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(new Q1051().heightChecker(heights));
    }
}
