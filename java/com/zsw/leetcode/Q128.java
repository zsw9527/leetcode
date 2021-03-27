package com.zsw.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();
        for (int tmp : nums) {
            set.add(tmp);
        }
        List<Integer> list = set.stream().collect(Collectors.toList());
        list.sort((a, b) -> a.compareTo(b));

        int i = 0;
        int res = 0;
        while (i < list.size()) {
            int start = i;

            while (i+1 < list.size() && (list.get(i) + 1 == list.get(i+1))) {
                i++;
            }
            int end = i+1;
            if (res < end - start) {
                res = end - start;
            }

            i = end;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(new Q128().longestConsecutive(nums));
    }
}
