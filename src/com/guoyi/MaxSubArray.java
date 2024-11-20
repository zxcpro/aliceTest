package com.guoyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

    /*
    53.给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和,子数组是数组中的一个连续部分。
    示例 1：
    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    示例 2：
    输入：nums = [5,4,-1,7,8]
    输出：23

    动态规划：无后效行
    只输出结果，不需要记录子序列，可以用滚动变量表达
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            //前缀和还大于0，就加进去
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }


    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(new int[]{1, 2, -2, 1});
        System.out.println(i);

    }


}
