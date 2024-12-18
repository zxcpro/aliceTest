package com.guoyi;

import java.util.Random;

public class SortArray {

    //912 快速排序
    //https://www.hello-algo.com/chapter_sorting/quick_sort/#__tabbed_1_8


    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }


    //哨兵划分，哨兵找到正确位置
    private int partition(int[] nums, int left, int right) {
        // 以 nums[left] 为基准数
        int num = nums[left];
        int i = left, j = right;
        while (i < j) {
            // 从右向左找首个小于基准数的元素
            while (i < j && nums[j] >= num) {
                j--;
            }
            // 从左向右找首个大于基准数的元素
            while (i < j && nums[i] <= num) {
                i++;
            }
            // 交换这两个元素
            swap(nums, i, j);
        }
        // 将基准数交换至两子数组的分界线
        swap(nums, i, left);
        // 返回基准数的索引
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        int[] nums = {2,1,4,0,3};
        sortArray.sortArray(nums);
        System.out.println(nums);
    }

    /**
     * 对数组 nums 的子区间 [left, right] 使用插入排序
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }


}
