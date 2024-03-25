package com.guoyi;

import com.guoyi.CommonTool.ListNode;

public class SortList {

    //148. 排序链表
    public ListNode sortList(ListNode head) {
        //1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        //2、找到链表中点并断开，向下递归
        ListNode midNode = middleNode(head);
        ListNode rightNode = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);

        //3、合并排序两个链表
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;

        while(left != null && right !=null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        cur.next = left !=null?left:right;
        return sentry.next;
    }

    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        //注意，初始化fast右移2位
        //1、因为要控制不要切到小于2个
        //2、right是middle的next，控制在奇数多的1放在后面队列好了
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(2);
        ListNode listNode4 = new ListNode(3,listNode5);
        ListNode listNode3 = new ListNode(1,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(4,listNode2);

        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(listNode1);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
