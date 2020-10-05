package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        int sum = 0;
        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int i = b + 1;
                int j = nums.length - 1;
                while (i < j) {
                    sum = nums[a] + nums[b] + nums[i] + nums[j];
                    if (target < sum) {
                        j--;
                    } else if (target > sum) {
                        i++;
                    } else {
                        resList.add(new ArrayList<>(Arrays.asList(nums[a], nums[b], nums[i], nums[j])));
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        j--;
                        while (i < j && nums[i] == nums[i+1]) {
                            i++;
                        }
                        i++;
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        Q18 q18 = new Q18();
        List<List<Integer>> resList = q18.fourSum(arr, 0);
        for (List<Integer> tmpList : resList) {
            tmpList.stream().forEach(e-> System.out.print(e + " "));
            System.out.println();
        }
    }
}
