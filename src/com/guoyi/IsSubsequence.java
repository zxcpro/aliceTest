package com.guoyi;

public class IsSubsequence {

    /*
    392 判断子序列
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
    进阶：
    如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
    示例 1：
    输入：s = "abc", t = "ahbgdc"
    输出：true
    */

    //双指针，子序列
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            //s是子序列，s的元素在全序列中存在，就向后移动一位
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        //子序列的所有长度都移动完，证明存在
        return i == n;
    }
}
