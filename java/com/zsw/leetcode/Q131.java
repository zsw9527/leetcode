package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrace(res, 0, s, stack);
        return res;
    }

    public void backtrace(List<List<String>> res, int first, String s, Stack<String> stack) {
        if (first == s.length()) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = first; i < s.length(); ++i) {
            if (!checkPalindrome(s, first, i)) {
                continue;
            }
            stack.push(s.substring(first, i+1));
            backtrace(res, i+1, s, stack);
            stack.pop();
        }
    }

    public boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
