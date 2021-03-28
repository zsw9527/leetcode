package com.zsw.leetcode;

import java.util.*;

public class Q139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    public static void main(String[] args) {
        String[] arr = {"leet", "code"};
        List<String> wordDict = Arrays.asList(arr);
        System.out.println(new Q139().wordBreak("leetcode", wordDict));
    }
}
