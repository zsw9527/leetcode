package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 */
public class Q216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[10];
        dfs(1, k, n, res, new ArrayList<>(), visited);
        return res;
    }

    void dfs(int start, int k, int n, List<List<Integer>> res, List<Integer> out,
             boolean[] visited) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(out));
        }
        for (int i = start; i <= 9; ++i) {
            if (!visited[i]) {
                out.add(i);
                visited[i] = true;
                dfs(start + 1, k - 1, n - i, res, out, visited);
                visited[i] = false;
                out.remove(out.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Q216().combinationSum3(3, 7);
        for (List<Integer> t : res) {
            t.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }
}
