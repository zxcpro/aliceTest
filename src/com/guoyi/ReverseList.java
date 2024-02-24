package com.guoyi;

import com.guoyi.CommonTool.ListNode;

public class ReverseList {

    /*
    206 反转链表
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    示例 1：
    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]
     */

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
