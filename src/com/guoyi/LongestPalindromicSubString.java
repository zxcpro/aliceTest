package com.guoyi;

public class LongestPalindromicSubString {
    /*
    5 最长回文子串
    题目：给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：
    输入：s = "cbbd"
    输出："bb"
     */

    //扩展中心法 时间复杂度O(n方)，空间复杂度O(1)
    //https://leetcode.cn/problems/longest-palindromic-substring/solutions/9001/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        //回文串左边start，右边end
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数
            int len1 = expandAroundCenter(s, i, i);
            //偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start ) {
                if(len==len1){
                    start = i - (len - 1) / 2;
                    end = i + (len-1) / 2;
                }else{
                    //偶数时候，基准在中间两个数的第1个数，所以要少减多加
                    start = i - (len - 2) / 2;
                    end = i + len/ 2 ;
                }
            }
        }
        //substring是截取到第二个参数的前1位，所以要+1，比如[2,4)，就是2,3
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //其实是 r -1 - （l + 1） +1 = r -l -1;
        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("ccccbk");
        System.out.println(s);
    }

}
