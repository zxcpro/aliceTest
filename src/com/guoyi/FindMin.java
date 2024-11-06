package com.guoyi;

public class FindMin {

    /* 153 寻找旋转排序数组中的最小值
    已知一个长度为n的数组，预先按照升序排列，经由1到n次**旋转**后，得到输入数组。例如，原数组nums = [0,1,2,4,5,6,7]在变化后可能得到：
    - 若旋转 `4` 次，则可以得到 `[4,5,6,7,0,1,2]`
    - 若旋转 `7` 次，则可以得到 `[0,1,2,4,5,6,7]`
    找最小值
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public int search(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length -1;

        return res;
    }
}
