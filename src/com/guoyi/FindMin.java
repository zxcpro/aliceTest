package com.guoyi;

public class FindMin {

    //153. 寻找旋转排序数组中的最小值

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int mid;
        while (left<right){
            mid = left + (right-left)/2;
            if(nums[mid]<nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }

        }
        return nums[right];
    }
}
