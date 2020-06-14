package com.zsw.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        Deque<Character> que = new LinkedList<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            while (que.contains(s.charAt(i))) {
                que.pop();
                j++;
            }
            que.offer(s.charAt(i));
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
