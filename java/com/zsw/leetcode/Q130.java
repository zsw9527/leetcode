package com.zsw.leetcode;

public class Q130 {
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if ((i == r-1 || j == c-1 || i == 0 || j == 0) && (board[i][j] == 'O')) {
                    /**
                     * 从边上的O遍历，将边上能达到的O记为N(表示无法改成X)
                     */
                    bfs(i, j, board);
                }
            }
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(int i, int j, char[][] board) {
        board[i][j] = 'N';//标记
        for (int s = 0; s < 4; ++s) {
            int x = i + dx[s];
            int y = j + dy[s];
            if (x >= 0 && y >= 0 && y < board[0].length && x < board.length && board[x][y] == 'O') {
                bfs(x, y, board);
            }
        }
    }
}
