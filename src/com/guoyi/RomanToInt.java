package com.guoyi;

public class RomanToInt {
    /*
    13 罗马数转int
    题目：罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    示例 1:
    输入: s = "IX"
    输出: 9
    示例 2:
    输入: s = "LVIII"
    输出: 58
    解释: L = 50, V= 5, III = 3.
     */

    /*
    思路，列举出来罗马数字的整数，然后替换
     */
    public int romanToInt(String s) {
        //注意，是IV IX，不是IV VX；
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res + getValue(s.charAt(i));
        }
        return res;
    }

    private int getValue(char c) {
        //switch语法， switch() case'1' : return 1;
        //最后要有个兜底，没有满足条件的，return 0;
        switch (c) {
            case 'I':
                return 1;
            case 'a':
                return 4;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }

}
