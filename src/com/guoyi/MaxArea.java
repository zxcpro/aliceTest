package com.guoyi;

public class MaxArea {

    /*
    11 盛水最多的容器
    给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    说明：你不能倾斜容器。

    输入：[1,8,6,2,5,4,8,3,7]
    输出：49
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

    复杂度分析：
    时间复杂度 O(N)​ ： 双指针遍历一次底边宽度N
    空间复杂度 O(1)：变量 i , j , res 使用常数额外空间。
     */

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while(l<r){
            int area = Math.min(height[l],height[r])*(r-l);
            ans = Math.max(ans,area);
            if(height[l]<=height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return ans;

    }

    public int maxAreaSimple(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea.maxArea(height);
    }

}
