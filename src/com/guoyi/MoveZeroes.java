package com.guoyi;


/**
 * Created by xuanchen.zhao on 2023/9/17.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {1,0,2,0,0,2,1,-3,6,5,3};
        moveZeroes.moveZeroes(nums);
    }

    /*
双指针移动零解法
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
 */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        //right溢出结束
        while (right < n) {
            //nums[right] != 0时候左右会一起右移，所有左==右
            // 右边是0时候，右边会右移，要把左边的0和右边交换，然后左边右移
            if (nums[right] != 0) {
                //这里隐藏了一个条件，只有left指向0的时候，双指针没有重叠，其他时间是重叠的，所以交换也没事
//                if(nums[left]==0){
                swap(nums, left, right);
//                }
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    //冒泡排序法，升序，也可以做移动零
    public void moveZeroesPop(int[] nums) {
        //需要循环数组长度那么多遍
        for(int i = 0;i<nums.length;i++){
            //每遍需要让当前的这个数字，向后移动到移动不了为止
            for(int j = 0;j<nums.length -1 - i;j++){
                //下面注释的行，这是升序的冒泡排序
                //if(nums[j] > nums[j+1]){
                if(nums[j] == 0){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        System.out.println(nums.toString());
    }


}
