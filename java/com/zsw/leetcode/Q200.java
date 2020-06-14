package com.zsw.leetcode;

public class Q200 {

    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (!flag[i][j] && grid[i][j] == '1') {
                    bfs(i, j, grid, flag);
                    res += 1;
                }
            }
        }
        return res;
    }

    public void bfs(int i, int j, char[][] grid, boolean[][] flag) {
        flag[i][j] = true;
        for (int s = 0; s < 4; ++s) {
            int x = i + dx[s];
            int y = j + dy[s];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !flag[x][y] && grid[x][y] == '1') {
                bfs(x, y, grid, flag);
            }
        }
    }
}
