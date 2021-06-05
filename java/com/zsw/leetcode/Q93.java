package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 */
public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() > 12 || s.length() < 4) {
            return res;
        }

        List<String> path = new ArrayList<>();
        dfs(s, 0, 4, path, res);
        return res;
    }

    /**
     * 回溯法
     * @param s 字符串
     * @param begin
     * @param residue 还剩几段
     * @param path
     * @param res
     */
    private void dfs(String s, int begin, int residue, List<String> path, List<String> res) {
        int len = s.length();
        if (begin == len) {
            //遍历到最后一个字符
            if (residue == 0) {//分成了4段，还剩0段
                //拼接ip地址4段放入res
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; ++i) {
            if (i >= len) {
                break;
            }
            //剪枝，剩下residue段根本不需要这么多字符
            if (residue * 3 < len - i) {
                continue;
            }
            if (isValidIP(s, begin, i)) {//是有效ip
                String currentIpSegment = s.substring(begin, i + 1);
                path.add(currentIpSegment);
                dfs(s, i + 1, residue - 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValidIP(String s, int left, int right) {
        int len = right - left + 1;
        //不能以0开头
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
