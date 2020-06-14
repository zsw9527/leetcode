package com.zsw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> curLsit, List<List<Integer>> res) {
        sum = sum - root.val;
        curLsit.add(root.val);
        if (root.left == null && root.right == null && sum == 0 ) {
            res.add(new ArrayList<>(curLsit));
        }
        if (root.left != null) {
            pathSum(root.left, sum, curLsit, res);
        }
        if (root.right != null) {
            pathSum(root.right, sum, curLsit, res);
        }
        curLsit.remove(curLsit.size()-1);
    }



    public static void main (String[] args){
        String s = "123";
        int[]numArray=new int[10];
        System.out.println(numArray[9]);
        System.out.println(numArray[10]);
        System.out.println(numArray.length);
    }
}
