package com.zsw.leetcode;

import java.util.HashMap;

public class Face07 {

    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < preorder.length; ++i) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(preorder[preStart]);
            int leftNodes = rootIndex-inStart, rightNodes = inEnd - rootIndex;
            root.left = buildTree(preorder, preStart+1, preStart + leftNodes, inorder, inStart, rootIndex-1);
            root.right = buildTree(preorder, preEnd-rightNodes+1, preEnd, inorder, rootIndex+1, inEnd);
            return root;
        }
    }
}
