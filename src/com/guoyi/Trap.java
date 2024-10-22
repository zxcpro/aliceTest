package com.guoyi;

public class Trap {
    /*
    42 接雨水
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    示例 1：
    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    思路：
    左右向中间移动，直到最高的点停止，双指针移动，过程中记录每一列能存贮的雨水高度
    1、记录解、左右指针位置、左右最高（和当前的差值就是当前列能存的水位）
    2、左右向中间移动，累加解
     */


    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preHigh = 0;
        int endHigh = 0;
        while (left < right) {
            preHigh = Math.max(preHigh, height[left]);
            endHigh = Math.max(endHigh, height[right]);
            if (height[left] < height[right]) {
                ans = ans + (preHigh - height[left]);
                left++;
            } else {
                ans = ans + (endHigh - height[right]);
                right--;
            }
        }
        return ans;
    }

}
