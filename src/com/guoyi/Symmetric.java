package com.guoyi;

public class Symmetric {
    /*
    101. 对称二叉树
    给你一个二叉树的根节点 root ， 检查它是否轴对称。
    示例 1：
    输入：root = [1,2,2,3,4,4,3]
    输出：true
     */
    public boolean isSymmetric(CommonTool.TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    boolean recur(CommonTool.TreeNode L, CommonTool.TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
