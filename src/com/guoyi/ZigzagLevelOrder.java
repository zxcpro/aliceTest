package com.guoyi;

import java.math.BigDecimal;
import java.util.*;

import com.guoyi.CommonTool.TreeNode;

public class ZigzagLevelOrder {

    /*
    103 二叉树的锯齿形层序遍历（广度优先遍历，清晰图解）
    给你二叉树的根节点root，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    示例1:
    输入：root = [3,9,20,null,null,15,7]
    输出：[[3],[20,9],[15,7]]
    示例 2：

    输入：root = [1]
    输出：[[1]]
    示例 3：

    输入：root = []
    输出：[]

    思考：
    1、初始化队列queue，放二叉树root方便后续向下遍历
    2、初始化 List<List<Integer>> res放结果
    3、循环，List<Integer> temp初始化临时变量，用来存储本层的变量，只要queue不为空，就取出queue poll取出队头，
    4、如果是奇数层，就正temp放入res，如果是偶数层，就reverse temp再放
    5、拼入res
    6、循环结束，返回res
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //必须用queue，因为queue有poll，从队列拿出最上层的元素
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.offer(root);//offer就是list的add
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //此时i=queue.size是进来while时候的size，for循环新加的不算了
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            //res.size是res当前存过的行数，当是奇数的时候，现在的temp就是偶数层，需要翻转
            if (res.size() % 2 == 1) Collections.reverse(temp);
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        TreeNode root = new TreeNode(3);

        // 第二层节点
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        // 第三层节点
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = zigzagLevelOrder.zigzagLevelOrder(root);
        System.out.println(lists.toString());

    }
}
