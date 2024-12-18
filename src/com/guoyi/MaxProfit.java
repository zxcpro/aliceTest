package com.guoyi;

public class MaxProfit {

    /*
    121 买卖股票的最佳时机
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    示例 1：
    输入：[7,1,5,3,6,4]
    输出：5
    示例 2：
    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    public int maxProfit(int[] prices){
        int benefit = 0;
        int cost = Integer.MAX_VALUE;
        if(prices == null || prices.length <2){
            return benefit;
        }

        for(int price : prices){
            cost = Math.min(cost,price);
            benefit = Math.max(benefit,price-cost);
        }
        return benefit;
    }

}
