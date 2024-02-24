package com.guoyi;

import com.guoyi.CommonTool.ListNode;
public class PartitionListNode {

    /*
    86 分割链表
    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    你应当 保留 两个分区中每个节点的初始相对位置。
    示例 1：
    输入：head = [1,4,3,2,5,2], x = 3
    输出：[1,2,2,4,3,5]
     */

    /*
    思考：
    1、初始化两个链表，分别记录小于和不小于的链表，并记录下来这两个链表的头。
    2、遍历完成后，把小链表尾的next指向记录好大链表的头。
    3、大链表的next置空
    4、返回，小链表的头
     */
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smallDummy,big = bigDummy;

        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigDummy.next;
        big.next = null;
        head = smallDummy.next;
        return head;
    }


}
