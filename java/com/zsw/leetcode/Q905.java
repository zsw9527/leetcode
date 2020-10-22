package com.zsw.leetcode;

public class Q905 {

    public int[] sortArrayByParity(int[] A) {
        int left = 0; 
        int right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 != 0 && A[right] % 2 == 0) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
            if (A[right] % 2 == 1) {
                right--;
            }
            if (A[left] % 2 == 0) {
                left++;
            }
        }
        return A;
    }

}