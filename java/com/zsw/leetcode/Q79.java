package com.zsw.leetcode;

public class Q79 {

    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0;  j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[m][n];
                    StringBuffer sb = new StringBuffer();
                    visited[i][j] = true;
                    sb.append(board[i][j]);
                    if (dfs(board, i, j, word, sb, visited, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, StringBuffer sb, boolean[][] visited, int len) {
        if (sb.toString().equals(word)) {
            return true;
        }

        boolean flag = false;
        for (int s = 0; s < 4; ++s) {
            int x2 = i + dx[s];
            int y2 = j + dy[s];

            if (x2 >= 0 && x2 < visited.length && y2 >= 0 && y2 < visited[0].length
                && len < word.length() && word.charAt(len) == board[x2][y2] && !visited[x2][y2]) {
                sb.append(board[x2][y2]);
                len++;
                visited[x2][y2] = true;

                flag |= dfs(board, x2, y2, word, sb, visited, len);

                visited[x2][y2] = false;
                sb.deleteCharAt(sb.length()-1);
                len--;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        char[][] board = {
            {'C','A','A'},
            {'A','A','A'},
            {'B','C','D'},
        };
        boolean r = new Q79().exist(board, "AAB");
        System.out.println(r);
    }

}
