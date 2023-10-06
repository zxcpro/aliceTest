package com.guoyi;

import java.util.Arrays;

/**
 * Created by xuanchen.zhao on 2023/9/29.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        //i是目标金额，j是硬币种类数量
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,2,5,10};
        int i = coinChange.coinChange(coins,5);
        System.out.println(i);
    }

}
