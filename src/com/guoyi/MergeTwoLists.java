package com.guoyi;

import com.guoyi.CommonTool.ListNode;

public class MergeTwoLists {
    /*
    21、合并两个有序链表
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    示例 1：
    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]
    示例 2：
    输入：l1 = [], l2 = []
    输出：[]
    示例 3：
    输入：l1 = [], l2 = [0]
    输出：[0]
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode(0);
        ListNode cur = tempHead;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(5, l1);
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode1 = mergeTwoLists.mergeTwoLists(l1, l2);
        System.out.println(listNode1.toString());
    }

}
