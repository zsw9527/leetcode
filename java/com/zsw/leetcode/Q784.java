package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q784 {

    public static void dfs(StringBuilder s, int index, List<String> res) {
        if(index >= s.length()) {
            res.add(s.toString());
            return;
        }
        char ch = s.charAt(index);
        if(ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
            dfs(s, index+1, res);					// 搜索原字母的组合
            s.setCharAt(index, (char)(ch ^ 32));
            dfs(s, index+1, res);					// 搜索转换字母大小写后的组合
        } else dfs(s, index+1, res);				// 该位为数字，直接往后搜
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        dfs(new StringBuilder(S), 0, res);
        return res;
    }


    public static void main(String[] args) {
        char a = 'a';
        a-=32;
        System.out.println(new Character(a));
    }
}
