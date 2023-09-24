package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /*
    22
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]

    示例 2：
    输入：n = 1
    输出：["()"]
     */

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gen = new GenerateParenthesis();
        List<String> str = gen.generateParenthesis(2);
        System.out.println(str);
    }
}
