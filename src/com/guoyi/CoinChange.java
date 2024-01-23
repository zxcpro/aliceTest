package com.guoyi;

import java.util.Arrays;

/**
 * Created by xuanchen.zhao on 2023/9/29.
 */
public class CoinChange {

    /*
    322 零钱兑换  动态规划
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    你可以认为每种硬币的数量是无限的。
    示例 1：
    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1
    示例 2：
    输入：coins = [2], amount = 3
    输出：-1
    示例 3：
    输入：coins = [1], amount = 0
    输出：0

    思路：memo[i] = Math.min(memo[i],memo[i-coins[j]] + 1)
    初始化每个值，用来算后面的值即可
    注意这里填充不能用Integer.MAX_VALUE ，因为如果这个位置没解决，这个地方+coins[j]还要用它+1，会溢出，所以是大于amount的数字即可
     */

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        //i是目标金额，j是硬币种类数量
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {2};
        int i = coinChange.coinChange(coins, 3);
        System.out.println(i);
    }

}
