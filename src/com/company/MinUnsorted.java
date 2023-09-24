package com.company;

import java.util.List;

public class MinUnsorted {

    public int findUnsortedSubarray(int[] nums) {
        Integer left = null;
        //从左向右找到非升序i
        for (int i = 0; i < nums.length; i++) {
            //i + 1不越界
            if (i + 1 < nums.length) {
                if (nums[i + 1] < nums[i]) {
                    left = i;
                    break;
                }
            }
        }

        if (left == null) {
            return 0;
        }

        //从右向左找到非降序j
        Integer right = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                if (nums[i - 1] > nums[i]) {
                    //print("assign right " + i);
                    right = i;
                    break;
                }
            }
        }


        if (right == null) {
            return 0;
        }


        //找到其中的最大、最小值
        Integer min = nums[left];
        Integer max = nums[left];
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        //从i开始向左check比最小值大的，如果只有相等的，可不计入
        for (int i = left; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            }
        }


        //从j向右check比最大值小的，如果只有相等的，可不计入
        for (int j = right; j < nums.length; j++) {
            if (nums[j] < max) {
                right = j;
            }
        }


        return right - left + 1;
    }

}
