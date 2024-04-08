package com.guoyi;
import com.guoyi.CommonTool.ListNode;

public class RemoveNthFromEnd {
    /*
    19  删除链表的倒数第 N 个结点
    给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
    示例 1：
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]
    时间复杂度：o(n),其中n是链表的长度。
    空间复杂度：O(1)。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode start = pre;
        ListNode end = pre;

        while(n!=0){
            end = end.next;
            n--;
        }
        while(end.next!=null){
            start = start.next;
            end = end.next;
        }

        start.next = start.next.next;
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode1 = removeNthFromEnd.removeNthFromEnd(listNode, 2);
        System.out.println(listNode1.toString());
    }


}
