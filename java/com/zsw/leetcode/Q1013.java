package com.zsw.leetcode;

public class Q1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3) return false;
        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
        }
        int target = sum / 3;

        int n = 0;
        sum = 0;
        int i;
        for (i = 0; i < A.length; ++i) {
            sum += A[i];
            if (sum == target) {
                n++;
                sum = 0;
            }
        }
        return n >= 3;
    }
}
