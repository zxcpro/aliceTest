package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class TreeInorder {

    //94 二叉树中序遍历
    /*
    给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
    示例 1：
    输入：root = [1,null,2,3]
    输出：[1,3,2]
     */

    public List<Integer> inorderTraversal(CommonTool.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(CommonTool.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}
