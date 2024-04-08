package com.guoyi;

import com.guoyi.CommonTool.ListNode;
public class DetectCycle {
    /*
    142 环形链表 II
    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    不允许修改 链表。
    示例 1：
    输入：head = [3,2,0,-4], pos = 1
    输出：返回索引为 1 的链表节点
    解释：链表中有一个环，其尾部连接到第二个节点。
     */

    /*
    双指针：快慢指针
    1、初始化快慢指针
    2、快指针找到慢指针，break
    3、快指针重置到头节点
    4、重新相遇，位置就是环的入口

    假设慢slow走s步，快fast走f步
    f = 2s
    f = s + nb
    所以s = nb
    从slow现在的位置走到链表环的入口节点，就是a+nb
    那么现在走a步，就到环的入口
    所以fast从头开始走，slow从现在位置走，走a步在入口处相遇
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
