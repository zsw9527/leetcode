package com.zsw.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> table = new HashMap<>();
        int left = 0, right = 0;
        int len = Integer.MIN_VALUE;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            table.put(ch, table.getOrDefault(ch, 0) + 1);

            if (table.get(ch) > 1) {
                while (left < right) {
                    if (s.charAt(left) == ch) {
                        table.put(ch, 1);
                        break;
                    } else {
                        table.remove(s.charAt(left));
                    }
                    left++;
                }
                left++;
            }
            if (right - left > len) {
                len = right - left;
            }
        }

        return len == Integer.MIN_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        new Q3().lengthOfLongestSubstring("tmmzuxt");
    }

}
