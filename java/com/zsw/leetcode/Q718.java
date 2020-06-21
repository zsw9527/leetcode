package com.zsw.leetcode;

public class Q718 {

    public int findLength(int[] A, int[] B) {
        int i,b;
        int len = 0;
        int[][] dp = new int[A.length + 1][B.length + 1]; //建立一个二维表。
        for(i = 1; i <= A.length; i++){
            for(b = 1; b <= B.length; b++){
                if(A[i - 1] == B[b - 1]){//如果两个元素相等，就看他前面一个元素匹配的结果。
                    dp[i][b] = dp[i - 1][b - 1] + 1;
                }
                if(dp[i][b] > len){//这里是找最长得长度
                    len = dp[i][b];
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        int len = new Q718().findLength(A, B);
        System.out.println(len);
    }
}
