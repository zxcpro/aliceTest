package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /*
    22 括号生成
    数字n代表生成括号（）的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]

    示例 2：
    输入：n = 1
    输出：["()"]
     */

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        backtrack(res, 0, 0, n, new StringBuilder());
        return res;
    }

    public void backtrack(List<String> res, int open, int close, int n, StringBuilder builder) {
        //1、记录解
        if (open == n && close == n) {
            res.add(builder.toString());
            return;
        }
        //2、剪枝，open>n，close>open的都不对
        if (open < n) {
            //3、尝试解的步骤
            builder.append("(");
            backtrack(res, open + 1, close, n, builder);
            //4、回退，加了一个字符，就回退一个字符
            builder.deleteCharAt(builder.length() - 1);
        }
        //这两个if谁先谁后都正确，结果集的顺序不太一样，一个是先open（，深度遍历，一个是先尽量关闭
        if (close < open) {
            builder.append(")");
            backtrack(res, open, close + 1, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gen = new GenerateParenthesis();
        List<String> str = gen.generateParenthesis(2);
        System.out.println(str);
    }
}
