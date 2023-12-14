package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class SplitPartition {

    /*
    131. 分割回文串
    给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
    回文串 是正着读和反着读都一样的字符串。
    示例 1：
    输入：s = "aab"
    输出：[["a","a","b"],["aa","b"]]
    示例 2：
    输入：s = "a"
    输出：[["a"]]
     */

    public List<List<String>> splitPartition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        char[] chars = s.toCharArray();
        backtrack(res, chars, 0, new ArrayList<String>());
        return res;
    }

    private void backtrack(List<List<String>> res, char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            if (!isPalindromic(i, index, chars)) {
                continue;
            }
            ans.add(new String(chars, index, i - index + 1));
            backtrack(res, chars, index + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }

    private boolean isPalindromic(int i, int index, char[] chars) {
        while (index < i) {
            if (chars[index] != chars[i]) {
                return false;
            }
            i--;
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitPartition splitPartition = new SplitPartition();
        List<List<String>> aab = splitPartition.splitPartition("aab");
        System.out.println(aab.toString());
    }
}
