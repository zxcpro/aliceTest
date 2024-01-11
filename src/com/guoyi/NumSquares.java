package com.guoyi;

public class NumSquares {

    /*
    279 完全平方数
    给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    示例 1：
    输入：n = 12
    输出：3
    解释：12 = 4 + 4 + 4
     */
    /*
    思考：
    每个数字都等于一个平方数加上余数的最优解解，f[n]=f[n-j*j]+1;
    1、初始化数组，记录每个位置的最优解
    2、遍历，每个i的初始位置最多是i个1的平方。
    3、i的求解过程，遍历j*j<=i次，f[n]=f[n-j*j]+1;
    4、输出f[n];
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int nummed = numSquares.numSquares(8);
        System.out.println(nummed);
    }
}
