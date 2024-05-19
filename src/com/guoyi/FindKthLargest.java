package com.guoyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindKthLargest {

    //215. 数组中的第 K 个最大元素
    //https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/
    private int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        return quickSelect(numList, k);
    }

    private int quickSelect(List<Integer> numList, int k) {

        Random rand = new Random();
        int i = rand.nextInt(numList.size());
        int pivot = numList.get(i);

        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();

        for (Integer num : numList) {
            if (num > pivot) {
                bigger.add(num);
            } else if (num < pivot) {
                smaller.add(num);
            } else {
                equals.add(num);
            }
        }

        if (k <= bigger.size()) {
            quickSelect(bigger, k);
        } else if (numList.size() - smaller.size() < k) {
            quickSelect(smaller, k - bigger.size() - equals.size());
        }

        return pivot;
    }


    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {2, 0, 2, 1, 4, 5, 3};
        int k = 3;
        int kthLargest = findKthLargest.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

}
