package com.guoyi;
import com.guoyi.CommonTool.ListNode;

public class ReverseKGroup {

    //25 k个一组反转链表
    //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
    //k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    //你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        while(head != null){
            ListNode start = head;
            for(int i = 1;i<k && head!=null;i++){
                head = head.next;
            }
            if(head == null){
                return dummy.next;
            }
            ListNode end = head;
            ListNode next = end.next;

            end.next = null;
            reverse(start);
            pre.next = end;
            start.next = next;
            pre = start;
            head = start.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node0 = new ListNode(0,node1);
        ListNode node = reverseKGroup.reverseKGroup(node0, 3);
        System.out.println(node.toString());
    }



}
