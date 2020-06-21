package com.zsw.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q633 {

    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int tmp = left * left + right * right;
            if (tmp == c) return true;
            else if (tmp < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q633().judgeSquareSum(1));
    }
}
