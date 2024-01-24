package com.guoyi;

public class MaxProduct {

    /*
    152 乘积最大子数组
    给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
    测试用例的答案是一个 32-位 整数。
    子数组 是数组的连续子序列。
    示例 1:
    输入: nums = [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。
    示例 2:
    输入: nums = [-2,0,-1]
    输出: 0
    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

    思考
    1、先找个地方记录解，max
    2、找解和前解的关系公式
    由于有正负，最大数，最小数都要记，万一遇到负值，最小的就最大了
    最大Math.max(imax*nums[i],nums[i]);
    最小Math.min(imin*nums[i],nums[i]);
    3、初始化记录解
    初始是1
    遍历，逐个套用关系公式得到解，正的时候，正常代入，负的时候，交换imax和imin
    4、记录解，由于结果不一定是最后一位的结果，要记录过程的解
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

}
