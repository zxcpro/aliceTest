package com.company;

import java.util.Arrays;

public class QuickSortTest {


    static void qSort(int[] list, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        //选定一个key，从从向前找一个比key小的，再从前向后找一个比key大的，进行交换
        int key = list[startIndex];
        int left = startIndex;
        int right = endIndex;

        while(right > left && list[right] > key) {
            right--;
        }
        //证明由于list[right] < key，找到了比key小的值
        if (right > left) {
            //替换掉这个值
            list[left] = list[right];
            //左侧值已被替换，到下一个备选值
            left++;
        }

        while(right > left && list[left] < key) {
            left++;
        }
        if (right > left) {
            list[right] = list[left];
            right--;
        }

        //left == right
        list[left] = key;
        //分别对左右侧再快速排序
        qSort(list, startIndex, left-1);
        qSort(list, left+1, endIndex);
    }

    static void quickSort(int[] list, int startIndex, int endIndex) {

        //终止递归条件
        if (startIndex >= endIndex) {
            return;
        }

        int key = list[startIndex];
        int i = startIndex;
        int j = endIndex;

        while(i < j) {
            //从后向前，找到一个比key小的值
            while (list[j] > key && i < j) {
                j--;
            }

            //确认是因为找到了比key小的数而停下循环
            if (i < j) {
                //把当前找到的j位置换到前面i指针的位置
                list[i] = list[j];
                //i的这个值就已经小于key了可以放过了
                i++;
            }

            //从前后找，找到一个比key大的数
            while (list[i] < key && i < j) {
                i++;
            }

            //确认是因为找到了比key大的数而停下循环
            if (i < j) {
                //把这个数放到当前j指向的位置
                list[j] = list[i];
                //j上的数已经比key大了，可以跳过到下一个数了
                j--;
            }
        }
        //i与j相遇了，把key值放在这里
        list[i] = key;

        //对key前面的数组进行快速排序
        quickSort(list, startIndex, i - 1);
        //对key后面的数组进行快速排序
        quickSort(list, i + 1, endIndex);


    }


    public static void main(String[] args) {
        int[] list =
                {1,10,3,6,7,11,4,19,25};
//        {1,5,3};
        qSort(list, 0 , list.length - 1);

        Arrays.stream(list).forEach( i -> System.out.println(i));
    }

}
