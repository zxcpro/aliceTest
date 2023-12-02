package com.guoyi;

public class IsPalindrome {

    /*
    9、回文数
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    例如，121 是回文，而 123 不是。
    示例 1：
    输入：x = 121
    输出：true

    示例 2：
    输入：x = -121
    输出：false
    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

    示例 3：
    输入：x = 10
    输出：false
    解释：从右向左读, 为 01 。因此它不是一个回文数。
     */

    /*
    思路：
    1、负数都不是回文数
    2、把数字反转过来
    3、跟原数字相等就是，不相等就不是回文数
    空间复杂度，没引入新的空间，O（1）
    时间复杂度，O（logn），每次都除以10了
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int cur = 0;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        if (cur == x) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int x = 98589;
        IsPalindrome palindrome = new IsPalindrome();
        boolean isPalindrome = palindrome.isPalindrome(x);
        System.out.println(isPalindrome);
    }
}
