package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Face1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(shorter, longer, k, set, new ArrayList<>(), shorter);
        int[] arr = new int[set.size()];
        int i = 0;
        for (int tmp : set) {
            arr[i++] = tmp;
        }
        return arr;
    }

    void dfs(int shorter, int longer, int k, TreeSet<Integer> all, List<Integer> cur, int tmp) {
        if (k == 0) {
            int sum = 0;
            for (int t : cur) {
                sum += t;
            }
            all.add(sum);
            return;
        }
        k -= 1;
        cur.add(tmp);
        dfs(shorter, longer, k, all, cur, shorter);
        dfs(shorter, longer, k, all, cur, longer);
        cur.remove(cur.size()-1);
        k += 1;
    }
}
