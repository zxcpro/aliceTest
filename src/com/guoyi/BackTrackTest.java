package com.guoyi;

import java.util.ArrayList;
import com.guoyi.CommonTool.TreeNode;

public class BackTrackTest {

    //在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径。
    //https://www.hello-algo.com/chapter_backtracking/backtracking_algorithm/

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<>();
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 尝试
        path.add(root.val);
        if (root.val == 7) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left);
        preOrder(root.right);
        // 回退
        path.remove(path.size() - 1);
    }

    //在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点。
    void preOrderNo3(TreeNode root) {
        // 剪枝
        if (root == null || root.val == 3) {
            return;
        }
        // 尝试
        path.add(root.val);
        if (root.val == 7) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left);
        preOrder(root.right);
        // 回退
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        BackTrackTest btt = new BackTrackTest();
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode7Root = new TreeNode(7,treeNode4,treeNode5);
        TreeNode treeNode3 = new TreeNode(3,treeNode6,treeNode7);
        TreeNode treeNode1 = new TreeNode(1,treeNode7Root,treeNode3);

        btt.preOrder(treeNode1);
        System.out.println(btt.res);
    }
}
