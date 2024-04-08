package com.guoyi;
import com.guoyi.CommonTool.ListNode;
public class SwapPairs {

    /*
    24. 两两交换链表中的节点
    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    示例 1：
    输入：head = [1,2,3,4]
    输出：[2,1,4,3]
    示例 2：
    输入：head = [2]
    输出：[2]
     */

    /*
    思考：
    两两交换思路，但是要记录位置
    1、初始化pre和一个temp，记录住原初始节点
    2、temp用来移动，后两个不为null就可以循环
    3、记录原来start和end
    4、然后交换
    5、把temp放到start的位置，此时位置在后面，向后继续循环
     */
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0,head);
        ListNode temp = pre;
        while(temp.next!=null && temp.next.next!=null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
