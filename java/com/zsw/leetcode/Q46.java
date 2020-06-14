package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int i : nums) {
            output.add(i);
        }
        permute(res, output, 0);
        return res;
    }

    public void permute(List<List<Integer>> res, List<Integer> output, int start) {
        if (start == output.size()) {
            res.add(new ArrayList<>(output));
        }
        for (int i = start; i < output.size(); ++i) {
            Collections.swap(output, start, i);
            permute(res, output, start+1);
            Collections.swap(output, start, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> res = new Q46().permute(nums);
        for (List<Integer> tmpList : res) {
            tmpList.stream().forEach(e-> System.out.print(e+" "));
            System.out.println();
        }
    }
}
