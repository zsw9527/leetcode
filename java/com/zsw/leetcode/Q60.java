package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q60 {

    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        StringBuilder solution = new StringBuilder();
        boolean[] visited = new boolean[n];
        backtrack(res,solution,n,k,visited);
        return res.get(k-1);
    }

    void backtrack(List<String> res, StringBuilder solution,int n,int k,boolean[] visited){
        if( res.size() == k) return;
        if( solution.length() == n){
            res.add(solution.toString());
            return;
        }
        for(int i = 1; i <= n; i++){
            if(visited[i-1]) continue;
            visited[i-1] = true;
            solution.append(i);
            backtrack(res,solution,n,k,visited);
            visited[i-1]=false;
            solution.deleteCharAt(solution.length() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q60().getPermutation(3, 3));
    }
}
