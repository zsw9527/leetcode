package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map[i][j] = '.';
            }
        }
        backtrace(res, map, 0, n);
        return res;
    }

    public void backtrace(List<List<String>> res, char[][] map, int row, int n) {
        //每行都摆满了皇后，产生一种解法
        if (row == n) {
            res.add(charToList(map));
        }
        for (int col = 0; col < n; ++col) {
            if (isVaild(map, row, col)) {
                //该行列放皇后合法
                map[row][col] = 'Q';
                backtrace(res, map, row+1, n);
                map[row][col] = '.';
            }
        }
    }

    //判断当前位置放子是否合法（同列同对角线都不行）
    public boolean isVaild(char[][] map, int row, int col) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                if (map[i][j] == 'Q' && (j == col || Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> charToList(char[][] map) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < map.length; ++i) {
            list.add(new String(map[i]));
        }
        return list;
    }
}
