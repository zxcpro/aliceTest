package com.guoyi;

public class CanPartition {

    /*
    416. 分割等和子集
    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    示例 1：
    输入：nums = [1,5,11,5]
    输出：true
    解释：数组可以分割成 [1, 5, 5] 和 [11] 。
    示例 2：
    输入：nums = [1,2,3,5]
    输出：false
    解释：数组不能分割成两个元素和相等的子集。
     */


    /*
    思考：
    1、子问题，有没有子序列的和是总和的一半，有 就说明能分成两个相等的子集。
    所以先算总和，总和是奇数，false
    2、再拆分子问题，状态定义，和状态转移
    2.1状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
    2.2状态转移方程：当前数字选和不选
    选，dp[i][j]的状态就等于，dp[i][j] = dp[i - 1][j - nums[i]]；
    不选，dp[i][j] = dp[i - 1][j];
    所以这两个任何一个有解，dp[i][j]就有解
    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
    3、初始化
    先初始化成全fasle
    初始化最开始的一行，也就是dp[0][j]这一行，那么目标值是第一个数字的有解，dp[0][nums[0]] = true；
    4、再算后面的
    从i=1，j=1开始算，因为是数组都是正整数，所以j<=0的都是fasle
    5、剪枝
    其中如果nums[i]>target，是false，所以状态转移公式的前提是nums[i]<=target
    如果dp[i][target]已经有解了，提前结束
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = num + sum;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum/2;
        //dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j，是否有解
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        //初始化，先填表格第0行，0行的其他解都是false，只有第1个数容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        //再填表格后面的行
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            //剪枝，如果其中某个位置的i，已经有target的解，直接返回，因为dp[i][j] = dp[i - 1][j]，前面已经有解
            if(dp[i][target]){
                return true;
            }
        }
        return dp[len - 1][target];
    }
}
