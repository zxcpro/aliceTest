package com.guoyi;

public class JieYushui {

    /*
    42、给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    输出：6
    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    时间复杂度：O(n)
    空间复杂度：O(1)
     */

    /*
    接雨水双指针解法的思路：
    每一个柱子能接的水=min（左右两边最高柱子）-当前柱子的高度
    leftMax就是每个柱子左边最高
    rightMax就是每个柱子右边最高
     */
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        JieYushui jieYushui = new JieYushui();
        int trap = jieYushui.trap(height);
        System.out.println(trap);
    }
}
