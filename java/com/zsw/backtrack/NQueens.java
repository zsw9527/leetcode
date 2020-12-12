package com.zsw.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * n后问题
 */
public class NQueens {

    private static List<List<String>> resList = new ArrayList<>();

    public static List<List<String>> nQueens(int n) {
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        backTrack(map, 0);
        return resList;
    }

    private static void backTrack(char[][] map, int row) {
        if (row == map.length) {
            //遍历到了最后一行
            resList.add(getString(map));
            return;
        }
        for (int col = 0; col < map.length; ++col) {
            if (!isValid(map, row, col)) {
                continue;
            }
            map[row][col] = 'Q';//放置皇后
            backTrack(map, row+1);
            map[row][col] = '.';
        }
    }

    private static boolean isValid(char[][] map, int row, int col) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                if (map[i][j] == 'Q' && (j == col || Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> getString(char[][] map) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < map.length; ++i) {
            stringList.add(new String(map[i]));
        }
        return stringList;
    }

    public static void main(String[] args) {
        List<List<String>> resList = nQueens(8);
        for (List<String> solution : resList) {
            solution.forEach(a -> System.out.println(a));
            System.out.println("----------------------");
        }
    }
}
