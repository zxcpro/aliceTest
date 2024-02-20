package com.guoyi;

import java.util.*;

import com.guoyi.CommonTool.TreeNode;

public class LevelOrder {
    /*
    102. 二叉树的层序遍历
    给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    示例 1：
    输入：root = [3,9,20,null,null,15,7]
    输出：[[3],[9,20],[15,7]]
    示例 2：
    输入：root = [1]
    输出：[[1]]
    示例 3：
    输入：root = []
    输出：[]

    https://leetcode.cn/problems/binary-tree-level-order-traversal/solutions/2361604/102-er-cha-shu-de-ceng-xu-bian-li-yan-du-dyf7/?envType=study-plan-v2&envId=top-100-liked
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(20,treeNode1,treeNode2);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode root = new TreeNode(3,treeNode4,treeNode3);
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        System.out.println(lists);
    }

}
