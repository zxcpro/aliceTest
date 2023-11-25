package com.guoyi;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    //6. N 字形变换
    /*
    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    P   A   H   N
    A P L S I I G
    Y   I   R
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);

    示例 1：
    输入：s = "PAYPALISHIRING", numRows = 3
    输出："PAHNAPLSIIGYIR"
    示例 2：
    输入：s = "PAYPALISHIRING", numRows = 4
    输出："PINALSIGYAHRPI"
    解释：
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    */

    /*
    解法：通过预测每个字母所在的行，来把字母append在对应行的字符串的最后，然后按行输出字符串
    时间复杂度：O(n)
    空间复杂度：O(n)
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        //初始化行数的字符串
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        //i是字母的行索引
        //flag是下一个字母要去的行与当前行的差量，当是0行或最后一行时，转弯，0是+1，最后一行是-1
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i = i + flag;
        }
        //创建字符串，把多行按顺序append
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Convert convert = new Convert();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String res = convert.convert(s, numRows);
        System.out.println(res);

    }
}
