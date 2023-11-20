package com.guoyi;

public class LongestPalindromicSubString {
    //5 最长回文子串
    /*
    给你一个字符串 s，找到 s 中最长的回文子串。
    如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：
    输入：s = "cbbd"
    输出："bb"
     */

    //明显涉及拆分子问题和推导，使用动态规划
    //如果f(start, end) 是一个回文子串
    //start-1与end+1都存在且相等，则f(start-1,end+1)也是回文的
    //如果不存在或者不相等，则一定不是回文子串
    //即长串问题的结果 依赖于  短串问题的结果，先从短串开始计算
    //扩展中心法 时间复杂度O(n方)，空间复杂度O(1)
    //https://leetcode.cn/problems/longest-palindromic-substring/solutions/9001/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start ) {
                if(len==len1){
                    start = i - (len - 1) / 2;
                    end = i + (len-1) / 2;
                }else{
                    start = i - (len - 2) / 2;
                    end = i + len/ 2 ;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("ccccbk");
        System.out.println(s);
    }

}
