package com.company;

public class ContainerWithMostWater11 {


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater11().maxArea(height));
    }

    public int maxArea(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = height.length -1;

        int maxArea = 0;
        //计算当前面积
        //比较left和right中较小的一个，选择丢弃，left右移或者right左移
        while(leftIndex < rightIndex) {
            int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            //如果比最大还要大，则记录下来
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[leftIndex] <= height[rightIndex]) {
                //左侧较小，放弃左侧
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }

}
