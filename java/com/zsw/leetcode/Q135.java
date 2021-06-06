package com.zsw.leetcode;

import java.util.Arrays;

/**
 * 分发糖果
 */
public class Q135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        //考虑比左边高的情况
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        int res = left[ratings.length - 1];
        //考虑比右边高的情况
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
}
