package com.guoyi;

public class StrToInt {

    /*
    8 字符转化数字
     */

    public int strToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        //1、先把空格去掉
        char[] c = s.trim().toCharArray();
        //2、res记录结果，sign记录符号，i记录数字起始位，从符号位后面，下标1开始
        int res = 0;
        int sign = 1;
        int i = 1;
        if (c[0] == '-') {
            sign = -1;
        }
        //3、如果没符号，数字起始位从第0个开始
        else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            //如果不允许有非数字，那就直接break，如果非数字过滤跳过，就continue
            if (c[j] < '0' || c[j] > '9') break;
            //4、判断字符的数字范围是否超过int，int的最后1位，正7付8
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //5、res原res左移1位，加上当前值
            res = res * 10 + c[j] - '0';
        }
        return sign * res;
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        int num = strToInt.strToInt(" 67h8998");
        System.out.println(num);
    }

}
