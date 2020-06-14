package com.zsw.leetcode;

import java.util.Stack;

public class Q20 {

    private boolean isLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }


    public boolean isValid(String s) {
        if (s.length() % 2 == 1) // 奇数个字符的字符串 显然无法完成括号匹配
            return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (isLeft(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    while (!s.isEmpty()) {
                        char c = stack.pop();
                        if (c == '(' && s.charAt(i) == ')' ||
                                c == '{' && s.charAt(i) == '}' ||
                                c == '[' && s.charAt(i) == ']') {
                            break;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Q20().isValid("[])"));
    }
}
