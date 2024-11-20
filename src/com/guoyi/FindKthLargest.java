package com.guoyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindKthLargest {

    /*215. 数组中的第 K 个最大元素
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

    示例 1:
    输入: [3,2,1,5,6,4], k = 2
    输出: 5
    也就是升序排序后，倒数第k个数字，就是第k大
    https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/
     */
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }

    private int quickSelect(List<Integer> numList, int k) {
        int randomNum = numList.get(0);

        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();

        for (Integer num : numList) {
            if (num > randomNum) {
                bigger.add(num);
            } else if (num < randomNum) {
                smaller.add(num);
            } else {
                equals.add(num);
            }
        }

        //第k大的元素还在bigger里，还要按照k继续递归
        if (k <= bigger.size()) {
            return quickSelect(bigger, k);
        }
        //第k大的元素在smaller里，继续递归，smaller里的长度应该是k-不在smaller的长度
        else if (numList.size() - smaller.size() < k) {
            return quickSelect(smaller, k - bigger.size() - equals.size());
        }
        //第k大就是和这个数字一样
        return randomNum;
    }



    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {2, 0, 2, 1, 4, 5, 3};
        int k = 3;
        int kthLargest = findKthLargest.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

}
