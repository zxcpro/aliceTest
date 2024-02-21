package com.guoyi;

import com.guoyi.CommonTool.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    /*
    114. 二叉树展开为链表
    给你二叉树的根结点 root ，请你将它展开为一个单链表：
    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。
    输入：root = [1,2,5,3,4,null,6]
    输出：[1,null,2,null,3,null,4,null,5,null,6]
     */

    /*
    思考：
    1、先使用144 二叉树的前序遍历，把顺序排好，获得一个List<TreeNode>
    2、遍历list，创建treenode赋值进去，只赋右子树，变成链表
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
