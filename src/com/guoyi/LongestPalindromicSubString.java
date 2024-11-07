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
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        //回文串左边start，右边end
        int start = 0, end = 0;
        //每个位置为中心时的解
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

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //其实是 r -1 - （l + 1） +1 = r -l -1;
        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubString longest = new LongestPalindromicSubString();
        String s = longest.longestPalindrome1("ccccbk");
        System.out.println(s);
    }


    public String longestPalindrome1(String s) {
        if(s == null || s.length() <2){
            return s;
        }
        String res = "";
        for(int i = 0;i<s.length();i++){
            int len1 = getLongest(s,i,i);
            int len2 = getLongest(s,i,i+1);
            if (len1 > len2){
                if(len1>res.length()){
                    res = s.substring(i-(len1-1)/2,i+(len1-1)/2 +1);
                }
            }else{
                if (len2 > res.length()){
                    res = s.substring(i-(len2-2)/2,i+(len2)/2 + 1);
                }
            }
        }

        return res;

    }

    private int getLongest(String s,int i,int j){

        int left = i;
        int right = j;
        while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right -1 - (left + 1) +1;
    }

}
