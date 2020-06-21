package com.zsw.leetcode;

import java.util.Arrays;

public class Q1033 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a=arr[0];
        b=arr[1];
        c=arr[2];
        int min = 0;
        if (c - a == 2) min = 0;
        else if (b - a == 1 || c - b == 1) min = 1;
        else if (b - a == 2 || c - b == 2) min = 1;
        else min = 2;
        return new int[]{min, c - a - 2};
    }

    public static void main(String[] args) {
        int[] res = new Q1033().numMovesStones(1, 4, 7);
        for (int tmp : res) {
            System.out.print(tmp + " ");
        }
    }
}
