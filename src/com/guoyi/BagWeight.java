package com.guoyi;

/**
 * Created by xuanchen.zhao on 2023/9/29.
 */
public class BagWeight {

    /*
    背包问题，背包可以放目标cap重量，现在有重量wgt和价值val的物品list
    例：wgt[] = {10,20,30,40,50}；val[] = {50,120,150,210,240}；背包可以放50g重量，求最大价值
    每个物品可以拿1次
     */
    /*
        dp状态定义：当前物品编号i和背包容量c，记为[i,c]。可选的n个物品和c容量，建设c+1，n+1 大小的二维表
        状态[i,c]对应的子问题为：前i个物品在容量为的背包中的最大价值，记为dp[i,c]
         */

    int knapsackDP(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化 dp 表，dp表代表，i位置存储c重量下的最大价值key
        int[][] dp = new int[n + 1][cap + 1];
        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                if (wgt[i - 1] > c) {
                    // 若超过背包容量，则不选物品 i
                    dp[i][c] = dp[i - 1][c];
                } else {
                    // 不选和选物品i这两种方案的较大值
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }

    /*
    完全背包，每个物品可以拿多次
     */
    int unboundedKnapsackDP(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化 dp 表
        int[][] dp = new int[n + 1][cap + 1];
        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                if (wgt[i - 1] > c) {
                    // 若超过背包容量，则不选物品 i
                    dp[i][c] = dp[i - 1][c];
                } else {
                    // 不选和选物品 i 这两种方案的较大值
                    //每个物品有无数个，因此将物品i放入背包后，仍可以从前个物品中选择i，而不是i-1
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i][c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }


    int unboundedKnapsackDPComp(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        // 初始化 dp 表
        int[] dp = new int[cap + 1];
        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                if (wgt[i - 1] > c) {
                    // 若超过背包容量，则不选物品 i
                    dp[c] = dp[c];
                } else {
                    // 不选和选物品 i 这两种方案的较大值
                    dp[c] = Math.max(dp[c], dp[c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[cap];
    }

    public static void main(String[] args) {

        int[] wgt = {10,20,30,40,50};
        int[] val = {50,120,150,210,240};
        int cap = 50;
        BagWeight bagWeight = new BagWeight();
        int i = bagWeight.unboundedKnapsackDP(wgt, val, cap);
        System.out.println(i);

    }


}
