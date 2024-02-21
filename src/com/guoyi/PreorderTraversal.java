package com.guoyi;

import com.guoyi.CommonTool.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    /*
    144 二叉树的前序遍历
    输入：root = [1,null,2,3]
    输出：[1,2,3]

    思考：
    前序遍历就是  根节点-左子树-右子树
    按顺序递归即可
    1、初始化结果值
    2、递归
    2.1 记录当前值
    2.2 记录完根节点-左递归-右递归
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode root,List<Integer> res){
        if(root == null){
            return ;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}
