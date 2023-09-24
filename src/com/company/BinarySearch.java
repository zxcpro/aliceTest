package com.company;

public class BinarySearch {

    static int binarySearch(int[] sortedList, int target, int startIndex, int endIndex) {
        //终止条件
        if (startIndex > endIndex) {
            return -1;
        }

        //找到中间数
        int mid = (startIndex + endIndex)/2;

        //与target对比
        //如果相等则退出，返回当前index
        if (sortedList[mid] == target) {
            return mid;
        }

        //比target大则递归后半部分二分
        else if (sortedList[mid] > target) {
            return binarySearch(sortedList, target, startIndex, mid-1);
        }

        //比target小则递归前半部分二分
        else
            return binarySearch(sortedList, target, mid+1, endIndex);


    }

    public static void main(String[] args) {
        int[] sortedList = {1,2,5,8,11,15,25};
        System.out.println(binarySearch(sortedList, 5, 0, sortedList.length - 1));

    }
}
