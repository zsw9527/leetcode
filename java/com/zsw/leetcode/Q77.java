package com.zsw.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new LinkedList<>();
        LinkedList<Integer> currList = new LinkedList<>();
        backtrace(1, n, k, currList, resList);
        return resList;
    }

    private void backtrace(int first, int n, int k, LinkedList<Integer> curList, List<List<Integer>> resList) {
        if (curList.size() == k) {
            resList.add(new LinkedList<>(curList));
        }
        for (int i = first; i< n + 1; ++i) {
            curList.add(i);
            backtrace(i+1, n, k, curList, resList);
            curList.removeLast();
        }
    }
}
