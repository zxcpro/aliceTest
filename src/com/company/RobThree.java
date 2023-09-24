package com.company;

public class RobThree {

    public int rob(TreeNode root) {
        //当前节点可选可不选
        return robRecur(root, true);
    }

    public int robRecur(TreeNode node, boolean canChoose) {
        if (node == null) {
            return 0;
        }
        //如果不选，则左右子树可选的最大值加和
        //比较选和不选更大值

        //如果选择了，则左右子节点必须不选的最大值加和
        int chooseRootMaxLeft = robRecur(node.left, false);
        int chooseRootMaxRight = robRecur(node.right, false);

        int chooseMaxVal = node.val + chooseRootMaxLeft + chooseRootMaxRight;

        //如果不选当前节点
        int nonChooseRootMaxLeft = robRecur(node.left, true);
        int nonChooseRootMaxRight = robRecur(node.right, true);

        int nonChooseMaxVal = nonChooseRootMaxLeft + nonChooseRootMaxRight;

        return Math.max(chooseMaxVal, nonChooseMaxVal);

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
