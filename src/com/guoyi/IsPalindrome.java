package com.guoyi;

public class IsPalindrome {

    /*
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
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int div = 1;
        while(x/div>=10){
            div=div*10;
        }
        while(x>0){
            int left = x/div;
            int right = x%10;
            if(left!=right){
                return false;
            }
            //%是余数，/是除得
            //去掉第一位，取余，比如939%100=39
            x = (x%div) ;
            //去掉最后以为，比如39/10 = 3；
            x = x/10;
            div = div/100;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 98589;
        IsPalindrome palindrome = new IsPalindrome();
        boolean isPalindrome = palindrome.isPalindrome(x);
    }
}
