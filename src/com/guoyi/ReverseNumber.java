package com.guoyi;

public class ReverseNumber {

    /*
    7 整数反转
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。

    示例 1：
    输入：x = 123
    输出：321
    示例 2：
    输入：x = -123
    输出：-321
    示例 3：
    输入：x = 120
    输出：21
    示例 4：
    输入：x = 0
    输出：0
     */

    /*
    思路：
    不考虑Interger的范围的话，这个题目很好做，取余，然后把余数放在首位，赋值反转即可
    考虑范围就要考虑不大于最大值，不小于最小值，超过的就返回溢出
    每次取余数，然后当前数除以10去掉最后1位，继续
    结果res = 当前res*10 + 最新余数
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //取当前余数，就是最后一位
            int tmp = x % 10;
            //如果已经大于最大值的前n-1位，那再加1位肯定溢出
            //或者等于前n-1位，但是这次的tmp>7，maxvalue的最后一位是7
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            //同理，已经小于最小数的n-1位
            //或者等于，但是tmp<8，minvalue的最后一位是-8
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            //res = 当前res*10 + 最新余数
            res = res * 10 + tmp;
            //x除以10，去掉最后1位
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MIN_VALUE;
        int num3 = 0;
        int num4 = 12345;
        ReverseNumber reverseNumber = new ReverseNumber();
        int reverse = reverseNumber.reverse(num1);
        System.out.println(reverse);
    }

}
