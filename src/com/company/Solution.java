package com.company;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        generateParenthesis(1);
    }

    public static List<String> generateParenthesis(int n) {
        String s = "  I like this  ";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
        return null;
    }

    public Set<String> recur(int n) {
        //todo 退出条件
        if (n == 1) {
            Set<String> set = new HashSet<>();
            set.add("()");
            return set;
        }

        //对于n-1得到的每一个解
        Set<String> currentAns = new HashSet<>();
        for(String s : recur(n-1)) {
            //每一个位置尝试插入一个()，再去重
            for (int i = 0; i <= s.length(); i++) {
                currentAns.add(s.substring(0, i) + "()" + s.substring(i));
            }
        }

        return currentAns;
    }
}