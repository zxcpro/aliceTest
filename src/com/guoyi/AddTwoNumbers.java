package com.guoyi;

import com.guoyi.CommonTool.ListNode;

public class AddTwoNumbers {

    /* 2、两数相加
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
        //1、记录头节点
        ListNode head = null;
        //2、记录结果的链表
        ListNode res = null;
        //3、记录进位
        int carry = 0;
        //4、只要有一个链表不为null，就进入循环，计算记录结果
        while (l1 != null || l2 != null) {
            //5、取出两个链表的val
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            //6、记录和，l1+l2+carry
            int sum = n1 + n2 + carry;
            //7、如果是第一个数，初始化head和res，sum余10，余数的就是非进位的数字，如果不是第一个数，赋值到next，然后更新res
            if (head == null) {
                head = res = new ListNode(sum % 10);
            } else {
                res.next = new ListNode(sum % 10);
                res = res.next;
            }
            //8、记录进位carry
            carry = sum / 10;
            //9、更新l1、l2
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //10、如果最后有进位，那么再加一个节点记录进位1
        if (carry > 0) {
            res.next = new ListNode(carry);
        }
        return head;
    }


    public ListNode addTwoNumbersDiGui(ListNode l1, ListNode l2) {
        //记录进位increase，递归
        int increase = 0;
        return plusNextNode(l1, l2, increase);
    }

    public ListNode plusNextNode(ListNode l1, ListNode l2, int increase) {
        //均为空，则结束，没有下一个plusNextNode调用，递归结束
        if(l1 == null && l2 == null && increase == 0) {
            return null;
        }

        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        int sum = val1 + val2 + increase;
        sum = sum % 10;
        increase = sum / 10;
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
