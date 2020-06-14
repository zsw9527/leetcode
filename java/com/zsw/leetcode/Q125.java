package com.zsw.leetcode;

public class Q125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q125().isPalindrome("abA"));
    }
} 