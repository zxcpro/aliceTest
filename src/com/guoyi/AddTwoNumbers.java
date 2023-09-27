package com.guoyi;

import com.guoyi.CommonTool.ListNode;

public class AddTwoNumbers {

    /*
    2、两数相加
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头

    示例 1：
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.
    示例 2：

    输入：l1 = [0], l2 = [0]
    输出：[0]
    示例 3：

    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    输出：[8,9,9,9,0,0,0,1]

    提示：
    每个链表中的节点数在范围 [1, 100] 内
    0 <= Node.val <= 9
    题目数据保证列表表示的数字不含前导零
     */

    /*
    时间复杂度：O(max⁡(m,n))，其中 m 和 n 分别为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
    空间复杂度：O(1)。注意返回值不计入空间复杂度。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;//记录进位
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                //如果是第一个数，初始化head和tail
                // sum余10，余数的就是非进位的数字
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //sum除10，0或者1，记录进位
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果最后有进位，那么再加一个节点记录进位1
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


    public ListNode addTwoNumbersDiGui(ListNode l1, ListNode l2) {
        //两个链表同时遍历，如果有进位则记进位，和+1
        //注意考虑一个list截止另一个未截止的场景
        //注意考虑最后一个节点有进位时，最后还需要一个节点为1
        boolean increase = false;
        return plusNextNode(l1, l2, increase);
    }

    public ListNode plusNextNode(ListNode l1, ListNode l2, boolean increase) {
        //注意空节点
        //selectNextNode(l1, l2)
        //如果二者都不为空，则二者和+increase生成新节点
        //如果一个为空，一个不为空，则使用非空节点值生成新节点+increase
        //如果都为空，increase为true，还需要再生成一个节点
        if(l1 == null && l2 == null && !increase) {
            return null;
        }

        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        int sum = val1 + val2;
        if(increase) {
            sum++;
        }

        if(sum >= 10) {
            increase = true;
            sum = sum%10;
        } else {
            increase = false;
        }
        ListNode current = new ListNode(sum);
        current.next = plusNextNode(
                l1 != null ? l1.next : null,
                l2 != null ? l2.next : null, increase);
        return current;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(5, l1);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode1 = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode1.toString());
    }
}
