package com.guoyi;

import com.guoyi.CommonTool.ListNode;
public class DeleteNode {

    /*
    237. 删除链表中的节点
    输入：head = [4,5,1,9], node = 5
    输出：[4,1,9]
    解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
