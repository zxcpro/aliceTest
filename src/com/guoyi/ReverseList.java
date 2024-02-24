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

    /*
    思路：双指针，反转方向
    1、初始化当前指针cur、前一个指针pre
    2、cur向后遍历，到null为止
    3、初始化一个temp记录cur.next的位置。
    cur指向pre（重要，，转向了）
    pre、cur都向后移动一位
    4、返回：pre
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            //初始化一个
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
