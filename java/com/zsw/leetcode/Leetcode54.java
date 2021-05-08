package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();

        int l = 0, r = matrix[0].length - 1,u = 0, d = matrix.length-1;

        while(true) {
            for(int i = l; i <= r; ++i)
                resList.add(matrix[u][i]); //向右移动直到最右
            if(++ u > d) break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同

            for(int i = u; i <= d; ++i)
                resList.add(matrix[i][r]); //向下
            if(-- r < l) break; //重新设定有边界

            for(int i = r; i >= l; --i)
                resList.add(matrix[d][i]); //向左
            if(-- d < u) break; //重新设定下边界

            for(int i = d; i >= u; --i)
                resList.add(matrix[i][l]); //向上
            if(++ l > r) break; //重新设定左边界
        }
        return resList;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Leetcode54().spiralOrder(matrix);
    }
}
