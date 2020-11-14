package com.zsw.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Q7 {

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
