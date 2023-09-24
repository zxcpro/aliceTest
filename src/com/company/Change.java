package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Change {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(new Change().coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        //硬币数量不限制，不能缩小问题范围，只能在amount上缩小范围
        //递归方式，需要记录子问题解
        Map<Integer, Integer> cache = new HashMap<>();
        return coinRecur(coins, amount, cache);
//        return coinDP(coins, amount);

    }

    //动态规划法，自底向上推导解
    private int coinDP(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        //dp[0]代表金额为0的组合
        dp[0] = 0;

        //尝试去掉一个硬币金额，从 i - coins[j] 来推导当前的解
        for (int i = 1; i <= amount; i++) {
            int minCoinCount = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int remains = i - coins[j];
//                System.out.println("Removing coin:" + coins[j] + " remains:" +remains);
                //remains不存在，或者没有组成remains的组合
                if (remains < 0) {
                    continue;
                }
                //remains不存在解
                if (dp[remains] == -1) {
                    continue;
                }
                //remains的解存在
                minCoinCount = Math.min(minCoinCount, dp[remains]);
            }
//            System.out.println("Iterate i:" + i + " min:" + minCoinCount);
            //不存在能组合成当前值的解，dp[i] = 0
            //存在，则dp[i]为minCoinCount + 1
            if (minCoinCount != Integer.MAX_VALUE) {
                dp[i] = minCoinCount + 1;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    private int coinRecur(int[] coins, int amount, Map<Integer, Integer> cache) {
        //todo 记忆法
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (cache.get(amount) != null) {
            return cache.get(amount);
        }

        //尝试减去一个硬币数，比较其中最少的解
        int minCoinCount = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int remains = amount - coins[i];
            int remainCoinCount = coinRecur(coins, remains, cache);
            if (remainCoinCount == -1) {
                continue;
            }
            minCoinCount = Math.min(minCoinCount, coinRecur(coins, remains, cache) + 1);
        }

        Integer finalAns;
        //不存在一个解，返回-1
        if (minCoinCount == Integer.MAX_VALUE) {
            finalAns = -1;
        } else {
            finalAns = minCoinCount;
        }

        cache.put(amount, finalAns);
        return finalAns;
    }

}
