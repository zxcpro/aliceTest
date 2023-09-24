package com.guoyi;
import com.guoyi.CommonTool.ListNode;

public class RemoveNthFromEnd {
    /*
    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    示例 1：
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]
     */

    //计算链表长度
    /*
    时间复杂度：o(n),其中n是链表的长度。
    空间复杂度：O(1)。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = temp;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = temp.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    //双指针
    /*
    时间复杂度：o(n),其中n是链表的长度。
    空间复杂度：O(1)。
     */

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode first = head;
        ListNode second = temp;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = temp.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode1 = removeNthFromEnd.removeNthFromEnd2(listNode, 2);
        System.out.println(listNode1.toString());
    }


}
