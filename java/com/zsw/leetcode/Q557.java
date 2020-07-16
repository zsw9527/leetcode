package com.zsw.leetcode;

public class Q557 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        int i = 0;
        for (String tmp : str) {
            sb.append(reverse(tmp.toCharArray()));
            if (i++ < str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private char[] reverse(char[] ch) {
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
        return ch;
    }

    public static void main(String[] args) {
        String str = "We are family";
        System.out.println(new Q557().reverseWords(str));
    }
}
