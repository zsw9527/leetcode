package com.zsw.leetcode;

public class Q334 {

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; ++i) {
            char tmp = s[len-1-i];
            s[len-1-i] = s[i];
            s[i] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a','b','c','d','e'};
        new Q334().reverseString(s);
        System.out.println(new String(s));
    }
}
