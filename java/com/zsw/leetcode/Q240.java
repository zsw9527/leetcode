package com.zsw.leetcode;

/**
 * 搜索二维矩阵
 */
public class Q240 {

	public boolean searchMatrix(int[][] matrix, int target) {
        int raw = 0;
        int col = matrix[0].length - 1;

        while (raw < matrix.length && col > 0) {
            if (matrix[raw][col] == target) {
                return true;
            } else if (matrix[raw][col] > target) {
                col--;
            } else {
                raw++;
            }
        }

        return false;
    }
	
	public static void main(String[] args) {
		int[][] arr = {{-5}};
		
		new Q240().searchMatrix(arr, -5);
	}
}
