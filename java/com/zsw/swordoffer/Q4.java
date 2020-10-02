package com.zsw.swordoffer;

public class Q4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean res = false;
        if (matrix.length == 0) {
            return res;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                res = true;
                break;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        Q4 q4 = new Q4();
        System.out.println(q4.findNumberIn2DArray(matrix, -5));
    }
}
