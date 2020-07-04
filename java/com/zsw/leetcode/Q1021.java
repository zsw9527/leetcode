package com.zsw.leetcode;

import java.util.Stack;

public class Q1021 {

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int left = 0;
        while (i != S.length()) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else {
                stack.pop();
                sum += 2;
            }
            if (stack.isEmpty()) {
                sum -= 2;
                sb.append(S.substring(left+1, left+sum+1));
                left = left+sum+2;
                sum = 0;
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "(()())(())";
        Q1021 q = new Q1021();
        String res = q.removeOuterParentheses(str);
        System.out.println(res);
    }
}
