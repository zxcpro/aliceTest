package com.guoyi;
import com.guoyi.CommonTool.ListNode;

public class ReverseKGroup {

    //25 k个一组反转链表
    //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
    //k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    //你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode tail = head;

        while(head!=null){
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reserve(head,tail);
            ListNode headReverse = reverse[0];
            ListNode tailReverse = reverse[k-1];
            pre.next = headReverse;
            tailReverse.next = next;
            pre = tailReverse;
            head = tailReverse.next;
        }
        return dummy.next;
    }

    private ListNode[] reserve(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
}
